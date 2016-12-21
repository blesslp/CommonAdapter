package com.blesslp.adapter.compat.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.blesslp.adapter.compat.base.common.AdapterItem;
import com.blesslp.adapter.compat.base.common.BaseViewHolder;
import com.blesslp.adapter.compat.base.intf.CommonAdapterIntf;
import com.blesslp.adapter.compat.base.intf.CommonViewHolderIntf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liufan on 16/12/1.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<CommonRecyclerViewHolder> implements CommonAdapterIntf {
    private HashMap<Object, AdapterItem> typePool = new HashMap<>();

    private ArrayList<Object> types = new ArrayList<>();

    private List dataSource = new ArrayList();

    private TypeConvert typeConvert = new DefaultClassTypeConvert();


    @Override
    public void setTypeConvert(TypeConvert typeConvert) {
        this.typeConvert = typeConvert;
    }

    @Override
    public void setDataSource(List dataSource) {
        setDataSource(dataSource, true);
    }

    @Override
    public void setDataSource(List dataSource, boolean clearAll) {
        if (clearAll) {
            this.dataSource.clear();
        }
        if(dataSource != null) {
            this.dataSource.addAll(dataSource);
        }
        notifyDataSetChanged();
    }

    @Override
    public <T> List<T> getDataSource() {
        return dataSource;
    }

    private RecyclerAdapter(){}

    private RecyclerAdapter(HashMap<Object,AdapterItem> typePool, ArrayList<Object> types) {
        this.typePool = typePool;
        this.types = types;
    }


    @Override
    public void insertData(Object dat, int position) {
        this.dataSource.add(position, dat);
        notifyItemInserted(position);
    }

    @Override
    public void addData(Object dat) {
        insertData(dat,this.dataSource.size());
    }

    @Override
    public void deleteData(int position) {
        this.dataSource.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public AdapterItem getAdapterItem(int position) {
        Object convert = this.typeConvert.convert(this, position);
        return this.typePool.get(convert);
    }

    //还需要一个数据集

    @Override
    public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Object aClass = this.types.get(viewType);
        AdapterItem adapterItem = this.typePool.get(aClass);
        adapterItem.setContext(parent.getContext());
        adapterItem.setDataSource(this.dataSource);
        BaseViewHolder commonViewHolderIntf = adapterItem.onCreateViewHolder(parent);
        commonViewHolderIntf.setOnItemClickListener(adapterItem.itemClick);
        return new CommonRecyclerViewHolder(commonViewHolderIntf.getConvertView(), commonViewHolderIntf);
    }

    @Override
    public void onBindViewHolder(CommonRecyclerViewHolder holder, int position) {
        AdapterItem adapterItem = getAdapterItem(position);
        BaseViewHolder viewHolder = holder.getViewHolder();
        viewHolder.setCurrentPosition(position);
        adapterItem.setDataSource(this.getDataSource());
        adapterItem.onBindViewHolder(viewHolder,getItem(position),position);
    }


    @Override
    public <T> T getItem(int position) {
        return (T) this.dataSource.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        Object convertType = typeConvert.convert(this, position);
        int index = this.types.indexOf(convertType);
        if (index == -1) {
            throw new IllegalArgumentException(String.format("\n[%s] 此类型未在类型池找到,\n" +
                    "当前类型池:%s,\n" +
                    "请检查注册代码!!!",convertType,this.types));
        }
        return index;
    }

    @Override
    public int getItemCount() {
        return this.dataSource == null?0:dataSource.size();
    }

    public static class Builder extends CommonAdapterIntf.Builder<RecyclerAdapter>
    {
        @Override
        public <E, V extends AdapterItem<E, ? extends CommonViewHolderIntf>> Builder of(Object clazz, V adapterItem) {
            return (Builder) super.of(clazz, adapterItem);
        }

        @Override
        public RecyclerAdapter build() {
            return new RecyclerAdapter(getTypePool(),getTypes());
        }
    }



}
