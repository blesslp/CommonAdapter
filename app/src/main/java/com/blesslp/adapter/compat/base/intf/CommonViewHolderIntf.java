package com.blesslp.adapter.compat.base.intf;

import android.content.Context;
import android.view.View;

/**
 * Created by liufan on 16/12/1.
 */

public interface CommonViewHolderIntf<T extends CommonViewHolderIntf> {

    public View getConvertView();
    public Context getContext();
    public int getCurrentPosition();
    public void setCurrentPosition(int position);
}
