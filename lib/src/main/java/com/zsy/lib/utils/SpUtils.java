package com.zsy.lib.utils;

import android.content.Context;

import com.zsy.lib.utils.base.BaseSp;


/**
 * Created by 24275 on 2016/10/10.
 */

public class SpUtils {

    //Sp
    private static final String SettingSp = "SettingSp";

    private static final String StateSp = "StateSp";

    //Key
    private static final String FirstExecuteKey = "FirstExecuteKey";
    private static final String IsLoginedKey = "IsLoginedKey";
    private static final String AccountKey = "AccountKey";


    public static boolean isFirstExecute(Context context) {
        return (boolean) BaseSp.get(context, SettingSp, FirstExecuteKey, true);
    }

    public static void setExecuted(Context context) {
        BaseSp.put(context, SettingSp, FirstExecuteKey, false);
    }

    public static boolean isLogined(Context context) {
        return (boolean) BaseSp.get(context, SettingSp, IsLoginedKey, false);
    }

    public static void setLoginState(Context context, boolean loginState) {
        BaseSp.put(context, SettingSp, IsLoginedKey, loginState);
    }

    public static void putAccount(Context context, String account) {
        BaseSp.put(context, SettingSp, AccountKey, account);
    }

    public static String getAccount(Context context) {
        return (String) BaseSp.get(context, SettingSp, AccountKey, "");
    }

    public static void setState(Context context, String key, Object value) {
        BaseSp.put(context, StateSp, key, value);
    }

    public static Object getSate(Context context, String key, Object defaultValue) {
        return BaseSp.get(context, StateSp, key, defaultValue);
    }

}
