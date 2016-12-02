package com.blesslp.adapter.compat.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blesslp.adapter.compat.base.common.BaseViewHolder;
import com.blesslp.adapter.compat.base.intf.ViewHolderalbe;

/**
 * Created by liufan on 16/12/2.
 */

public class CommonRecyclerViewHolder<T extends BaseViewHolder> extends RecyclerView.ViewHolder implements ViewHolderalbe<T> {

    private T realViewHolder;

    public CommonRecyclerViewHolder(View itemView,T adapterItem) {
        super(itemView);
        this.realViewHolder = adapterItem;
    }

    @Override
    public void bindViewHolder(T adapterItem) {
        this.realViewHolder = adapterItem;
    }

    @Override
    public T getViewHolder() {
        return realViewHolder;
    }
}
