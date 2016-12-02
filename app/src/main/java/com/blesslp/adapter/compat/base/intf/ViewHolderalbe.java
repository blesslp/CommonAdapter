package com.blesslp.adapter.compat.base.intf;

import com.blesslp.adapter.compat.base.common.BaseViewHolder;

/**
 * Created by liufan on 16/12/2.
 */

public interface ViewHolderalbe<T extends BaseViewHolder> {

    public void bindViewHolder(T adapterItem);

    public T getViewHolder() ;

}
