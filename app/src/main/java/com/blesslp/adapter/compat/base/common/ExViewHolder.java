package com.blesslp.adapter.compat.base.common;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.util.SparseArrayCompat;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liufan on 16/12/21.
 */

public class ExViewHolder extends BaseViewHolder {
    private SparseArray<View> viewCache = new SparseArray<>();

    public ExViewHolder(View convertView) {
        super(convertView);
    }

    public <T extends View> T getView(@IdRes int viewId) {
        View view = viewCache.get(viewId);
        if (view == null) {
            view = getConvertView().findViewById(viewId);
            viewCache.put(viewId,view);
        }
        return (T) view;
    }

    public ExViewHolder(Context cx, @LayoutRes int layoutId, ViewGroup parent) {
        super(LayoutInflater.from(cx).inflate(layoutId,parent,false));
    }
}
