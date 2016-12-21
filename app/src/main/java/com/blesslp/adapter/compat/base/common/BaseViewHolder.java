package com.blesslp.adapter.compat.base.common;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.blesslp.adapter.compat.base.intf.CommonViewHolderIntf;

/**
 * Created by liufan on 16/12/2.
 */

public class BaseViewHolder implements CommonViewHolderIntf {

    private View convertView;
    private int currentPosition = -1;


    public BaseViewHolder(View convertView) {
        this.convertView = convertView;

    }

    @Override
    public View getConvertView() {
        return convertView;
    }

    @Override
    public Context getContext() {
        return convertView.getContext();
    }

    @Override
    public int getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void setCurrentPosition(int position) {
        this.currentPosition = position;
    }

    protected AdapterView.OnItemClickListener itemClick;

    public void setOnItemClickListener(final AdapterView.OnItemClickListener itemClick) {
        this.itemClick = itemClick;
        if (itemClick != null) {
            this.convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClick.onItemClick(null, view, getCurrentPosition(), getCurrentPosition());
                }
            });
        }
    }
}
