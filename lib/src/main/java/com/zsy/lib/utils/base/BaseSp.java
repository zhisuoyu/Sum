package com.zsy.lib.utils.base;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * Created by 24275 on 2016/6/24.
 */
public class BaseSp {

    public static final String SETTING = "setting";

    @SuppressWarnings("unchecked")
    public static void put(Context context, String filename, String key, Object obj) {
        SharedPreferences sp = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (obj instanceof Boolean) {
            editor.putBoolean(key, (Boolean) obj);
        } else if (obj instanceof Float) {
            editor.putFloat(key, (Float) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(key, (Integer) obj);
        } else if (obj instanceof Long) {
            editor.putLong(key, (Long) obj);
        } else if (obj instanceof String) {
            editor.putString(key, (String) obj);
        } else if (obj instanceof Set) {
            editor.putStringSet(key, (Set<String>) obj);
        }
        editor.apply();

    }

    @SuppressWarnings("unchecked")
    public static Object get(Context context, String filename, String key, Object defaultObj) {
        SharedPreferences sp = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        if (defaultObj instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObj);
        } else if (defaultObj instanceof Float) {
            return sp.getFloat(key, (Float) defaultObj);
        } else if (defaultObj instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObj);
        } else if (defaultObj instanceof Long) {
            return sp.getLong(key, (Long) defaultObj);
        } else if (defaultObj instanceof String) {
            return sp.getString(key, (String) defaultObj);
        } else if (defaultObj instanceof Set) {
            return sp.getStringSet(key, (Set<String>) defaultObj);
        }
        return null;
    }

    public static void remove(Context context, String filename, String key) {
        SharedPreferences sp = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }


    public static Map<String, ?> getAll(Context context, String filename) {
        SharedPreferences sp = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        Map<String, ?> map = sp.getAll();
        return map;
    }

    public static void clear(Context context, String filename) {
        SharedPreferences sp = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }


    public static boolean contains(Context context, String filename, String key) {
        SharedPreferences sp = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        return sp.contains(key);
    }

}
