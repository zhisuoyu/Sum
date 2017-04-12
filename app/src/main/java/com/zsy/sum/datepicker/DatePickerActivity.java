package com.zsy.sum.datepicker;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

import com.zsy.lib.app.BaseActivity;
import com.zsy.lib.utils.depend.Lg;
import com.zsy.sum.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mzs on 2017/4/11.
 */

public class DatePickerActivity extends BaseActivity {

    @BindView(R.id.tv_date_from) TextView dateFromTv;
    @BindView(R.id.tv_date_to) TextView dateToTv;

    @Override
    public void initContentView() {
        super.initContentView();
        setContentView(R.layout.activity_date_picker);


    }

    @OnClick(R.id.tv_date_from)
    void setFromDate() {
        Lg.i("from");
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);

        final int month = calendar.get(Calendar.MONTH);

        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog
                dialog = new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog,

                new DatePickerDialog.OnDateSetListener() {

                    @Override

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Lg.i(year + ";" + (monthOfYear + 1) + ";" + dayOfMonth);

                        dateFromTv.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }

                }, year, month, day) {

            @Override

            protected void onStop() {

                //解决执行两次onDateSet的bug，注释掉就可以了

                	super.onStop();

            }

        };
        dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
//        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 7 * 24 * 3600 * 1000);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
//        Lg.i(simpleDateFormat.format(System.currentTimeMillis()) + "=======" + simpleDateFormat.format(System.currentTimeMillis() - 7 * 24 * 3600 * 1000));
        dialog.show();
    }

    @OnClick(R.id.tv_date_to)
    void setToDate() {
        Lg.i("to");

    }
}
