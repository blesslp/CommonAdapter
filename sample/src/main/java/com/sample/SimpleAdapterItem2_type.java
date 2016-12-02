package com.sample;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blesslp.adapter.compat.base.common.AdapterItem;
import com.blesslp.adapter.compat.base.common.BaseViewHolder;
import com.blesslp.adapter.compat.recyclerview.RecyclerAdapter;

/**
 * Created by liufan on 16/12/2.
 */

public class SimpleAdapterItem2_type extends AdapterItem<User4,SimpleAdapterItem2_type.BV> {


    @Override
    public BV onCreateViewHolder(ViewGroup parent) {
        View v =  LayoutInflater.from(getContext()).inflate(R.layout.user_item2, parent, false);
        return new BV(v);
    }

    @Override
    public void onBindViewHolder(BV holder, User4 bean, int position) {
        holder.txtName.setText(bean.getName());
        holder.mAdapter.setDataSource(bean.getUsers());
    }

    public static class BV extends BaseViewHolder {

        private TextView txtName;
        private RecyclerView recyclerView;
        private RecyclerAdapter mAdapter;

        public BV(View convertView) {
            super(convertView);
            txtName = (TextView) convertView.findViewById(R.id.name);
            recyclerView = (RecyclerView) convertView.findViewById(R.id.recyclerView);
            mAdapter = new RecyclerAdapter.Builder().of(User4.class,new SimpleAdapterItem3_type()).build();
            recyclerView.setLayoutManager(new GridLayoutManager(getConvertView().getContext(), 3));
            recyclerView.addItemDecoration(new DividerItemDecoration(getConvertView().getContext(),DividerItemDecoration.HORIZONTAL));
            recyclerView.addItemDecoration(new DividerItemDecoration(getConvertView().getContext(),DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(mAdapter);
        }
    }
}
