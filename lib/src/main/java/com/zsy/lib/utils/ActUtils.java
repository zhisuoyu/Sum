package com.zsy.lib.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by 24275 on 2016/7/27.
 */
public class ActUtils {

    public static void act2Act(Activity act, Class<?> cls) {
        if (act == null || cls == null) {
            throw new NullPointerException(" act or cls null");
        }
        Intent intent = new Intent(act, cls);
        act.startActivity(intent);
    }

    public static void frag2Act(Fragment fragment, Class<?> cls) {
        if (fragment == null || cls == null) {
            throw new NullPointerException("fragment or cls null");
        }
        Intent intent = new Intent(fragment.getActivity(), cls);
        fragment.startActivity(intent);
    }

    public static boolean isActivityexist(Context context, String pkg, String cls) {
        Intent intent = new Intent();
        intent.setClassName(pkg, cls);
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }

    public void startOtherActivity(Context context, String pkg, String cls) {
        ComponentName componentName = new ComponentName(pkg, cls);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        context.startActivity(intent);
    }

}
