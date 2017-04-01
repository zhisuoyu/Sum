package com.zsy.lib.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by 24275 on 2016/9/22.
 */

public class FragmentUtils {

    private static void remove(FragmentManager fm, String flag) {
        Fragment fragment = fm.findFragmentByTag(flag);
        if (flag != null) {
            fm.beginTransaction().remove(fragment).commit();
        }
    }

    private static void remove(FragmentManager fm, Fragment fragment) {
        remove(fm, fragment.getClass().getName());
    }

    public static void add(FragmentManager fm, Fragment fragment, int containerViewId) {
        remove(fm, fragment);
        fm.beginTransaction().add(containerViewId, fragment, fragment.getClass().getName());
    }

    public static Fragment findStackFragment(FragmentManager fragmentManager, Class<? extends Fragment> fragmentClass) {
        return fragmentManager.findFragmentByTag(fragmentClass.getName());
    }

    public static void showHideFragment(FragmentManager fragmentManager, Fragment showFragment, Fragment hideFragment) {
        if (showFragment == hideFragment) {
            return;
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(showFragment);
        if (hideFragment != null) {
            fragmentTransaction.hide(hideFragment);
        }
        fragmentTransaction.commit();
    }

    public static void loadMultipleRootTransaction(FragmentManager fragmentManager, int containerId, int showPosition, Fragment... tos) {
        FragmentTransaction ft = fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        for (int i = 0; i < tos.length; i++) {
            Fragment to = tos[i];
            String toName = to.getClass().getName();
            ft.add(containerId, to, toName);
            if (i != showPosition) {
                ft.hide(to);
            }
        }
        ft.commit();
    }


}
