package com.blesslp.adapter.compat.abslistview;

import com.blesslp.adapter.compat.base.common.BaseViewHolder;
import com.blesslp.adapter.compat.base.intf.ViewHolderalbe;

/**
 * Created by liufan on 16/12/2.
 */

public class CommonAbstractViewHolder<T extends BaseViewHolder> implements ViewHolderalbe<T> {

    private T baseViewHolder;

    @Override
    public void bindViewHolder(T adapterItem) {
        this.baseViewHolder = adapterItem;
    }

    @Override
    public T getViewHolder() {
        return baseViewHolder;
    }
}
