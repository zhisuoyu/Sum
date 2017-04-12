package com.zsy.sum;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.zsy.lib.ui.test.TestActivity;
import com.zsy.lib.utils.PermissionUtils;
import com.zsy.lib.utils.depend.Lg;
import com.zsy.sum.datepicker.DatePickerActivity;
import com.zsy.sum.rv.RvActivity;

import java.util.Arrays;

public class MainActivity extends TestActivity {


    private final String[] dataArr = {"permission", "datePicker", "recyclerView"};

    @Override
    public void initActions() {
        datas = Arrays.asList(dataArr);
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                if (PermissionUtils.checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Lg.i("check1");
                    FileUtils.test();
                } else {
                    Lg.i("requestP");
                    PermissionUtils.requestPermission(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
                }
                break;
            case 1:
                startActivity(new Intent(this, DatePickerActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, RvActivity.class));
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1001:
                if (PermissionUtils.checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Lg.i("check2");
                    FileUtils.test();
                } else {
                    PermissionUtils.goSet(this, 1002);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Lg.i("requestCode:" + requestCode + ";;;;" + resultCode);
        if (PermissionUtils.checkPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            FileUtils.test();
        } else {
            Toast.makeText(this, "无权限", Toast.LENGTH_SHORT).show();
        }
    }
}
