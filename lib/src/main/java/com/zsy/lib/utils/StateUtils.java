package com.zsy.lib.utils;

public class StateUtils {


    public static int getFalseState() {
        return 0X00000000;
    }

    public static int getTrueState() {
        return 0XFFFFFFFF;
    }

    public static boolean isTrue(int state, int position) {
        checkPosition(position);
        return ((1 << position) & state) != 0;
    }

    public static int setTrue(int state, int position) {
        checkPosition(position);
        return (1 << position) | state;
    }

    public static int setFalse(int state, int position) {
        checkPosition(position);
        return state - (state & (1 << position));

    }

    public static void checkPosition(int position) {
        if (position < 0 || position > 31) {
            throw new IllegalArgumentException("position is out of boundary:" + position);
        }
    }

}
