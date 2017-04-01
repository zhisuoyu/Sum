package com.zsy.lib.utils;

import android.content.Intent;
import android.os.Bundle;

import java.util.Arrays;

/**
 * Created by 24275 on 2016/5/7.
 */
public class IterateIntent {

    public static final String KEY_FLAG = "key:";
    public static final String VALUE_FLAG = "value:";
    public static final String START_FLAG = "{";
    public static final String END_FLAG = "}";
    public static final String SPLIT_FLAG = ",";


    public static StringBuilder iterateBundle(Bundle bundle, StringBuilder sb) {
        if(bundle==null){
            sb.append("null");
            return sb;
        }
        sb.append(START_FLAG);
        for (String key : bundle.keySet()) {
            sb.append(START_FLAG + KEY_FLAG + key + SPLIT_FLAG + VALUE_FLAG);
            Object value = bundle.get(key);
            iterateObj(value, sb);
            sb.append(END_FLAG);
        }
        sb.append(END_FLAG);
        return sb;
    }

    public static StringBuilder iterateIntent(Intent intent, StringBuilder sb) {
        if(intent==null){
            sb.append("null");
            return sb;
        }
        iterateBundle(intent.getExtras(), sb);
        return sb;
    }

    public static StringBuilder iterateArray(Object o, StringBuilder sb) {
        sb.append(getArrStr(o));
        return sb;
    }

    private static String getArrStr(Object o) {
        String result = null;
        Class<?> cls = o.getClass().getComponentType();
        if (cls.equals(boolean.class)) {
            boolean[] arr = (boolean[]) o;
            result = Arrays.toString(arr);
        } else if (cls.equals(byte.class)) {
            byte[] arr = (byte[]) o;
            result = Arrays.toString(arr);
        } else if (cls.equals(char.class)) {
            char[] arr = (char[]) o;
            result = Arrays.toString(arr);
        } else if (cls.equals(short.class)) {
            short[] arr = (short[]) o;
            result = Arrays.toString(arr);
        } else if (cls.equals(int.class)) {
            int[] arr = (int[]) o;
            result = Arrays.toString(arr);
        } else if (cls.equals(long.class)) {
            long[] arr = (long[]) o;
            result = Arrays.toString(arr);
        } else if (cls.equals(float.class)) {
            float[] arr = (float[]) o;
            result = Arrays.toString(arr);
        } else if (cls.equals(double.class)) {
            double[] arr = (double[]) o;
            result = Arrays.toString(arr);
        } else {
            Object[] arr = (Object[]) o;
            result = Arrays.toString(arr);
        }
        return result;
    }


    public static void iterateObj(Object o, StringBuilder sb) {
        if (o == null) {
            sb.append("null");
        } else if (o.getClass().isArray()) {
            iterateArray(o, sb);
        } else if (o instanceof Intent) {
            iterateIntent((Intent) o, sb);
        } else if (o instanceof Bundle) {
            iterateBundle((Bundle) o, sb);
        } else {
            sb.append(o);
        }


    }


}
