package com.zsy.lib.utils;


import java.util.HashMap;

/**
 * Created by 24275 on 2016/8/24.
 */
public class EventFilter {

    private static final long DEFAULT_PERIOD = 1000;
    private static final String DEFAULT_TAG = "DEFAULT_TAG";

    private static HashMap<String, Long> mMaps = new HashMap<>();


    public static boolean isFastClick(String tag, long periodMs) {
        long currentTime = System.currentTimeMillis();
        if (!mMaps.containsKey(tag)) {
            mMaps.put(tag, currentTime);
            return false;
        }
        long preMs = mMaps.get(tag);
        if (currentTime - preMs >= periodMs) {
            mMaps.put(tag, currentTime);
            return false;
        }
        return true;
    }

    public static boolean isFastClick(String tag) {
        return isFastClick(tag, DEFAULT_PERIOD);
    }

    public static boolean isFastClick(long periodMs) {
        return isFastClick(DEFAULT_TAG, periodMs);
    }

    public static boolean isFastClick() {
        return isFastClick(DEFAULT_TAG);
    }

    public static void clear(String tag) {
        mMaps.remove(tag);
    }

    public static void clear() {
        clear(DEFAULT_TAG);
    }

    public static void clearAll() {
        mMaps.clear();
    }

}
