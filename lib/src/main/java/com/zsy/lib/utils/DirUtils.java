package com.zsy.lib.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;


public class DirUtils {
    private static final long ADDITIONAL_SAPCE = 5 * 1024 * 1024;

    /* Checks if external storage is available for read and write */
    public static boolean isExWriteable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public static boolean isExReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }


    public static File getInFileDir(Context context) {
        return context.getFilesDir(); // /data/data/com.belt.wg.myutils/files
    }

    public static File getInCacheDir(Context context) {
        return context.getCacheDir();// /data/data/com.belt.wg.myutils/cache
    }

    public static File getExRootDir() {
        return Environment.getExternalStorageDirectory();// /storage/sdcard0
    }

    public static File getExPrivateDir(Context context, String type) {
        return context.getExternalFilesDir(type); // /storage/sdcard0/Android/data/com.belt.wg.myutils/files/{type}
    }

    public static File getExPublicDir(String type) {
        return Environment.getExternalStoragePublicDirectory(type); // /storage/sdcard0/{type}
    }

    public static File getExCacheDir(Context context) {
        return context.getExternalCacheDir(); ///storage/sdcard0/Android/data/com.belt.wg.myutils/cache
    }

    public static boolean isSpaceEnough(File file, long contentLen) {
        return file.getFreeSpace() - contentLen >= ADDITIONAL_SAPCE;
    }

}
