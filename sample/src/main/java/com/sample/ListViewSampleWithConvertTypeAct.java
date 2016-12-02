package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.blesslp.adapter.compat.abslistview.ListViewAdapter;
import com.blesslp.adapter.compat.base.intf.CommonAdapterIntf;

import java.util.Arrays;

public class ListViewSampleWithConvertTypeAct extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private Button btnJumpToFirst;
    private ListViewAdapter mAdapter;  //ListView,GridView最上级的适配器,用于配置数据,不参与具体逻辑

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_sample_with_type);

        initViews();
        configListView();
    }

    public static final String TYPE_1 = "type1";
    public static final String TYPE_2 = "type2";
    public static final String TYPE_3 = "type3";

    private void configListView() {

        //配置ListView的数据类型及对应的Adapter
        mAdapter = new ListViewAdapter.Builder()
                .of(TYPE_1, new SimpleAdapterItem_type())
                .of(TYPE_2, new SimpleAdapterItem2_type())
                .of(TYPE_3, new SimpleAdapterItem3_type())
                .build();

        //设置数据源
        //设置自定义转换器
        mAdapter.setTypeConvert(new CommonAdapterIntf.TypeConvert() {
            @Override
            public Object convert(CommonAdapterIntf adapter, int position) {
                User4 user4 = adapter.getItem(position);
                return user4.getType();
            }
        });
        //模仿一个接口返回的数据中通过某个字段来划分不同视图的情况
        mAdapter.setDataSource(Arrays.asList(
                new User4("我是一个标题", Arrays.asList(new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1")),TYPE_2),
                new User4("sss", "www",TYPE_1),
                new User4("我是一个标题", Arrays.asList(new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1"),new User4("子标题1", "子内容1")),TYPE_2),
                new User4("单行数据", "enen",TYPE_3))
        );
        listView.setAdapter(mAdapter);
    }

    private void initViews() {
        btnJumpToFirst = (Button) findViewById(R.id.btnJumpToFirst);
        listView = (ListView) findViewById(R.id.listview);
        btnJumpToFirst.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
