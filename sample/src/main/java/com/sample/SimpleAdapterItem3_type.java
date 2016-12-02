package com.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blesslp.adapter.compat.base.common.AdapterItem;
import com.blesslp.adapter.compat.base.common.BaseViewHolder;

/**
 * Created by liufan on 16/12/2.
 */

public class SimpleAdapterItem3_type extends AdapterItem<User4,SimpleAdapterItem3_type.BV> {


    @Override
    public BV onCreateViewHolder(ViewGroup parent) {
       View v = LayoutInflater.from(getContext()).inflate(R.layout.user_item3, parent, false);
        return new BV(v);
    }

    @Override
    public void onBindViewHolder(BV holder, User4 bean, int position) {
        holder.txtName.setText(bean.getName());
        holder.txtAddress.setText(bean.getAddress());
    }

    public static class BV extends BaseViewHolder {

        private TextView txtName;
        private TextView txtAddress;

        public BV(View convertView) {
            super(convertView);
            txtName = (TextView) convertView.findViewById(R.id.name);
            txtAddress = (TextView) convertView.findViewById(R.id.address);
        }
    }
}
