package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.blesslp.adapter.compat.base.common.AdapterItem;
import com.blesslp.adapter.compat.base.intf.CommonAdapterIntf;
import com.blesslp.adapter.compat.recyclerview.RecyclerAdapter;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerAdapter mAdapter;       //RecyclerView最上级的适配器,用于配置数据,不参与具体逻辑
    private Button btnJumpToSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        configRecyclerView();
    }

    private void configRecyclerView() {
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //配置RecyclerView的数据类型及对应的Adapter
        mAdapter = new RecyclerAdapter.Builder()
                .of(User.class, new SimpleAdapterItem())
                .of(User2.class, new SimpleAdapterItem2())
                .of(User3.class, new SimpleAdapterItem3())
                .build();

        //设置数据源
        //默认类型是根据Class区分,也可自定义转换器来符合自己的逻辑

        mAdapter.setDataSource(Arrays.asList(
                new User("嘿嘿", "wuhan"),
                new User3("sss", "www"),
                new User2("我是一个标题", Arrays.asList(new User3("子标题1", "子内容1"),new User3("子标题2", "子内容2"),new User3("子标题3", "子内容3"),new User3("子标题4", "子内容4"),new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"))),
                new User("单行数据", "enen"))
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btnJumpToSecond = (Button) findViewById(R.id.btnJumpToSecond);
        btnJumpToSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,ListViewSampleAct.class));
    }
}
