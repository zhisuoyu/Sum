package com.zsy.sum.rv;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zsy.lib.app.BaseActivity;
import com.zsy.lib.utils.depend.Lg;
import com.zsy.sum.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * Created by mzs on 2017/4/11.
 */

public class RvActivity extends BaseActivity {

    private RvAdapter adapter;

    @BindView(R.id.rv_rv) RecyclerView rvRv;

    @Override
    public void initContentView() {
        super.initContentView();
        setContentView(R.layout.activity_rv);
    }

    @Override
    public void initView() {
        super.initView();
        initRv();
    }

    private void initRv() {
        final List<Object> datas = new ArrayList<>();
        datas.add(new Person(90, "mao"));
        datas.add(new Animal("dog", "yellow"));
        datas.add(new Animal("bird", "red"));
        datas.add(new Person(91, "mzs"));
        datas.add(new Person(92, "zsy"));
        datas.add(new Animal("cat", "white"));
        datas.add(new Person(90, "mao"));
        datas.add(new Animal("dog", "yellow"));
        datas.add(new Animal("bird", "red"));
        datas.add(new Person(91, "mzs"));
        datas.add(new Person(92, "zsy"));
        datas.add(new Animal("cat", "white"));
        adapter = new RvAdapter(datas);
        rvRv.setAdapter(adapter);
        rvRv.setLayoutManager(new LinearLayoutManager(this));
        rvRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastVisibleItem;
            private boolean isload = false;
            private boolean isNoMore = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//
                if (isNoMore) {
                    return;
                }
                if (!isload && lastVisibleItem + 6 >= adapter.getItemCount()) {
                    isload = true;
                    Lg.i("startLoad");
                    new Thread() {
                        @Override
                        public void run() {

                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    datas.add(new Person(90, "mao"));
                                    datas.add(new Animal("dog", "yellow"));
                                    datas.add(new Animal("bird", "red"));
                                    datas.add(new Person(91, "mzs"));
                                    datas.add(new Person(92, "zsy"));
                                    datas.add(new Animal("cat", "white"));
                                    datas.add(new Person(90, "mao"));
                                    datas.add(new Animal("dog", "yellow"));
                                    datas.add(new Animal("bird", "red"));
                                    datas.add(new Person(91, "mzs"));
                                    datas.add(new Person(92, "zsy"));
                                    datas.add(new Animal("cat", "white"));
                                    if (datas.size() > 100) {
                                        isNoMore = true;
                                        adapter.setNoMore(true);
                                    }
                                    adapter.notifyDataSetChanged();
                                    isload = false;
                                }
                            });
                        }
                    }.start();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = ((LinearLayoutManager) rvRv.getLayoutManager()).findLastVisibleItemPosition();
            }
        });
    }
}
