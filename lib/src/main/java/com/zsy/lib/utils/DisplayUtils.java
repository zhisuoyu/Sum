package com.zsy.lib.utils;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

/**
 * Created by mzs on 2016/11/10.
 */

public class DisplayUtils {


    /**
     * @param context
     * @return the DisplayMetrics of the device
     */
    public static DisplayMetrics getDM(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    public static int px2dp(Context context, float pxValue) {
        return (int) (pxValue / getDM(context).density + 0.5f);
    }

    public static int dp2px(Context context, float dpVaule) {
        return (int) (dpVaule * getDM(context).density + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        return (int) (spValue * getDM(context).scaledDensity + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        return (int) (pxValue / getDM(context).scaledDensity + 0.5);
    }


    /**
     * @param view
     * @param size 长度为2的数组，0位为宽，1位为高；
     * @return
     */
    public static void getViewSize(final View view, final int[] size) {
        if (size == null) {
            throw new NullPointerException("size == null");
        }
        if (size.length != 2) {
            throw new ArithmeticException("size.length != 2");
        }

        ViewTreeObserver vto = view.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                size[0] = view.getWidth();
                size[1] = view.getHeight();
            }
        });
    }

    public static int[] getViewSize(final View view) {
        final int[] size = new int[2];
        view.post(new Runnable() {
            @Override
            public void run() {
                size[0] = view.getWidth();
                size[1] = view.getHeight();
            }
        });
        return size;
    }


}
