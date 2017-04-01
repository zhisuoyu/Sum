package com.zsy.sum;

import com.zsy.lib.ui.test.TestActivity;
import com.zsy.lib.utils.depend.Lg;

import java.util.Arrays;

public class MainActivity extends TestActivity {


    private final String[] dataArr = {"signUp", "signIn", "signOut"};

    @Override
    public void initActions() {
        datas = Arrays.asList(dataArr);
    }

    @Override
    public void onItemClick(int position) {
        Lg.i(dataArr[position]);
    }
}
