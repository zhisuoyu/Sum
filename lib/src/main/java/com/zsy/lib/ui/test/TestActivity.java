package com.zsy.lib.ui.test;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsy.lib.R;
import com.zsy.lib.app.BaseActivity;

import java.util.List;

/**
 * Created by mzs on 2017/4/1.
 */

public abstract class TestActivity extends BaseActivity {

    protected List<String> datas;
    private TestRvAdapter adapter;

    private RecyclerView testRv;

    @Override
    public void initContentView() {
        super.initContentView();
        setContentView(R.layout.activity_test);
    }

    @Override
    public void initData() {
        super.initData();
        initActions();
        adapter = new TestRvAdapter(datas);
    }

    public abstract void initActions();

    public abstract void onItemClick(int position);

    @Override
    public void initView() {
        super.initView();
        testRv = (RecyclerView) findViewById(R.id.rv_test);
        testRv.setAdapter(adapter);
        testRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initEvent() {
        super.initEvent();
        adapter.setOnItemClickLsn(new TestRvAdapter.OnItemClickLsn() {
            @Override
            public void onItemClick(int position) {
                TestActivity.this.onItemClick(position);
            }
        });
    }
}
