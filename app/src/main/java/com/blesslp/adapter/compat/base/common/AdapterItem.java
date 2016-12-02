package com.blesslp.adapter.compat.base.common;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by liufan on 16/12/1.
 */

public abstract class AdapterItem<Entity,VH extends BaseViewHolder> {

    private Context _context;
    private List dataSource;

    public void setDataSource(List dataSource) {
        this.dataSource =dataSource;
    }

    public List<Entity> getDataSource() {
        return dataSource;
    }

    public void setContext(Context _context) {
        this._context = _context;
    }

    public Context getContext() {
        return _context;
    }

    public AdapterView.OnItemClickListener itemClick;

    public void setOnItemClickListener(AdapterView.OnItemClickListener itemClick) {
        this.itemClick = itemClick;
    }

    public abstract VH onCreateViewHolder(ViewGroup parent);

    public abstract  void onBindViewHolder(VH holder, Entity bean,int position);
}
