package com.blesslp.adapter.compat.base.intf;

import com.blesslp.adapter.compat.base.common.AdapterItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liufan on 16/12/2.
 */
public interface CommonAdapterIntf {
    void setTypeConvert(TypeConvert typeConvert);

    void setDataSource(List dataSource);

    void setDataSource(List dataSource, boolean clearAll);

    <T> List<T> getDataSource();

    void insertData(Object dat, int position);

    void addData(Object dat);

    void deleteData(int position);

    AdapterItem getAdapterItem(int position);

    <T> T getItem(int position);

    public interface TypeConvert {
        public Object convert(CommonAdapterIntf adapter, int position);
    }

    public static class DefaultClassTypeConvert implements TypeConvert{
        @Override
        public Object convert(CommonAdapterIntf adapter, int position) {
            return adapter.getItem(position).getClass();
        }
    }

    public abstract static class Builder<T extends CommonAdapterIntf> {
        private HashMap<Object,AdapterItem> typePool = new HashMap<>();

        private ArrayList<Object> types = new ArrayList<>();

        public ArrayList<Object> getTypes() {
            return types;
        }

        public HashMap<Object, AdapterItem> getTypePool() {
            return typePool;
        }

        public <E,V extends AdapterItem<E,? extends CommonViewHolderIntf>> Builder of(Object clazz, V adapterItem) {
            this.types.add(clazz);
            this.typePool.put(clazz, adapterItem);
            return this;
        }

        public abstract T build();
    }
}
