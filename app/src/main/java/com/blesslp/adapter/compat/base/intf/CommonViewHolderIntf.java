package com.blesslp.adapter.compat.base.intf;

import android.view.View;

/**
 * Created by liufan on 16/12/1.
 */

public interface CommonViewHolderIntf<T extends CommonViewHolderIntf> {

    public View getConvertView();
    public int getCurrentPosition();
    public void setCurrentPosition(int position);
}
