package com.zsy.lib.app.utils;

/**
 * Created by 24275 on 2016/9/19.
 */
public class AppState {

    private static AppState instance;

    private boolean isAppRunningForeground = false;

    private AppState() {
    }

    public static AppState getInstance() {
        if (instance == null) {
            synchronized (AppState.class) {
                if (instance == null) {
                    instance = new AppState();
                }
            }
        }
        return instance;
    }

    public boolean isAppRunningForeground() {
        return isAppRunningForeground;
    }

    public void setAppRunningForeground(boolean appRunningForeground) {
        isAppRunningForeground = appRunningForeground;
    }
}
