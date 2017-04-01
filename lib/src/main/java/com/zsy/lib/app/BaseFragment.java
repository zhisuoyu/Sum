package com.zsy.lib.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.zsy.lib.app.api.Init;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 24275 on 2016/10/8.
 */

public class BaseFragment extends Fragment implements Init {

    private final String KeyIsHidden = "KeyIsHidden";

    private LayoutInflater inflater;
    private ViewGroup container;
    private View layout;
    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        init();
        return layout;
    }

    @Override
    public void init() {
        initData();
        initContentView();
        unbinder = ButterKnife.bind(this, layout);
        initView();
        initInjector();
        initEvent();
    }

    @Override
    public  void initContentView(){};

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initInjector() {

    }

    @Override
    public void initEvent() {

    }

    //method
    protected void setContentView(int layoutResID) {
        layout = inflater.inflate(layoutResID, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            return;
        }
        boolean isHidden = savedInstanceState.getBoolean(KeyIsHidden);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (isHidden) {
            fragmentTransaction.hide(this);
        } else {
            fragmentTransaction.show(this);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KeyIsHidden, isHidden());
    }
}
