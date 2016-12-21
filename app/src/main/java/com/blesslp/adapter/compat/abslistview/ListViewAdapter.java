package com.blesslp.adapter.compat.abslistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.blesslp.adapter.compat.base.common.AdapterItem;
import com.blesslp.adapter.compat.base.common.BaseViewHolder;
import com.blesslp.adapter.compat.base.intf.CommonAdapterIntf;
import com.blesslp.adapter.compat.base.intf.CommonViewHolderIntf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liufan on 16/12/2.
 */

public class ListViewAdapter extends BaseAdapter implements CommonAdapterIntf{

    private HashMap<Object, AdapterItem> typePool = new HashMap<>();

    private ArrayList<Object> types = new ArrayList<>();

    private List dataSource = new ArrayList();

    private TypeConvert typeConvert = new DefaultClassTypeConvert();



    @Override
    public int getCount() {
        return dataSource==null?0:dataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private ListViewAdapter(HashMap<Object,AdapterItem> typePool, ArrayList<Object> types) {
        this.typePool = typePool;
        this.types = types;
    }



    @Override
    public void setTypeConvert(TypeConvert typeConvert) {
        this.typeConvert = typeConvert;
    }

    @Override
    public void setDataSource(List dataSource) {
        setDataSource(dataSource,true);
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

    @Override
    public void insertData(Object dat, int position) {
        this.dataSource.add(position,dat);
        notifyDataSetChanged();
    }

    @Override
    public void addData(Object dat) {
        insertData(dat,this.dataSource.size());
    }

    @Override
    public void deleteData(int position) {
        this.dataSource.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public AdapterItem getAdapterItem(int position) {
        Object convert = this.typeConvert.convert(this, position);
        return this.typePool.get(convert);
    }

    @Override
    public int getViewTypeCount() {
        return this.types==null?0:this.types.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object convert = typeConvert.convert(this, position);
        int index = this.types.indexOf(convert);
        if (index == -1) {
            throw new IllegalArgumentException(String.format("\n[%s] 此类型未在类型池找到,\n当前类型池:%s,\n请检查注册代码!!!",convert,this.types));
        }
        return index;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        AdapterItem adapterItem = getAdapterItem(position);
        adapterItem.setContext(viewGroup.getContext());
        adapterItem.setDataSource(this.getDataSource());

        BaseViewHolder viewHolder = null;
        if (convertView == null) {
            //需要一个viewholder
            viewHolder = adapterItem.onCreateViewHolder(viewGroup);
            convertView = viewHolder.getConvertView();
            convertView.setTag(viewHolder);
            //添加点击事件
            viewHolder.setOnItemClickListener(adapterItem.itemClick);
        }else{
            viewHolder = (BaseViewHolder) convertView.getTag();
        }

        //设置viewHolder的位置
        viewHolder.setCurrentPosition(position);
        //绑定数据
        adapterItem.onBindViewHolder(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();
    }

    public static class Builder extends CommonAdapterIntf.Builder<ListViewAdapter>
    {
        @Override
        public <E, V extends AdapterItem<E, ? extends CommonViewHolderIntf>> ListViewAdapter.Builder of(Object clazz, V adapterItem) {
            return (ListViewAdapter.Builder) super.of(clazz, adapterItem);
        }

        @Override
        public ListViewAdapter build() {
            return new ListViewAdapter(getTypePool(),getTypes());
        }
    }


}
