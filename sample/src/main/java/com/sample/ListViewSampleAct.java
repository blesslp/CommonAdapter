package com.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.blesslp.adapter.compat.abslistview.ListViewAdapter;

import java.util.Arrays;

public class ListViewSampleAct extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private Button btnJumpToThird;
    private ListViewAdapter mAdapter;  //ListView,GridView最上级的适配器,用于配置数据,不参与具体逻辑

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_sample);

        initViews();
        configListView();
    }

    private void configListView() {

        //配置ListView的数据类型及对应的Adapter
        mAdapter = new ListViewAdapter.Builder()
                .of(User.class, new SimpleAdapterItem())
                .of(User2.class, new SimpleAdapterItem2())
                .of(User3.class, new SimpleAdapterItem3())
                .build();

        //设置数据源
        mAdapter.setDataSource(Arrays.asList(
                new User2("我是一个标题", Arrays.asList(new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"))),
                new User3("sss", "www"),
                new User2("我是一个标题", Arrays.asList(new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"),new User3("子标题1", "子内容1"))),
                new User("单行数据", "enen"))
        );
        listView.setAdapter(mAdapter);
    }

    private void initViews() {
        btnJumpToThird = (Button) findViewById(R.id.btnJumpToThird);
        listView = (ListView) findViewById(R.id.listview);
        btnJumpToThird.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,ListViewSampleWithConvertTypeAct.class));
    }
}
