package com.zsy.lib.utils.depend;

import android.util.Log;

import com.orhanobut.logger.Logger;

/**
 * Created by 24275 on 2016/9/29.
 */

public class Lg {

    public static final int ErrorLevel = 1;
    public static final int WarnLevel = 2;
    public static final int InfoLevel = 3;
    public static final int DebugLevel = 4;
    public static final int VerboseLevel = 5;

    public static final String LgHttpReq = "LgHttpReq";
    public static final String LgHttpRep = "LgHttpRep";


    public static final int LogType = 0; //android util
    public static final int LoggerType = 1; //logger
    private static final boolean Debug = true;

    private static int sLgLevel = 5;
    private static boolean sOnlyLevel = false; //true log only lgLvel;or all level <=lgLevel

    private static final String Tag = "LgTag";


    private static int sType = LoggerType;
    private static String sTag = Tag;

    private static final int MethodCount = 1;
    private static final int MethodOffset = 2;


    public static void init(int type, String tag, int lgLevel, boolean onlyLevel) {
        if (!Debug) {
            return;
        }
        sTag = tag;
        sType = type;
        sLgLevel = lgLevel;
        sOnlyLevel = onlyLevel;
    }


    public static void init(int type, String tag) {
        if (!Debug) {
            return;
        }
        init(type, tag, VerboseLevel, false);
    }


    public static void init(int type) {
        if (!Debug) {
            return;
        }
        init(type, Tag);
    }

    public static void v(int type, String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(VerboseLevel)) {
            return;
        }
        if (msg == null) {
            msg = "null";
        }
        if (tag == null) {
            tag = Tag;
        }
        if (type == LogType) {
            Log.v(tag, msg);
        } else {
            loggerV(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (sType == LogType) {
            v(sType, tag, msg);
        } else {
            loggerV(tag, msg);
        }
    }

    public static void v(String msg) {
        if (sType == LogType) {
            v(sTag, msg);
        } else {
            loggerV(sTag, msg);
        }
    }

    private static void loggerV(String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(VerboseLevel)) {
            return;
        }
        Logger.init(tag).methodOffset(MethodOffset).methodCount(MethodCount);
        Logger.v(msg);
    }


    public static void d(int type, String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(DebugLevel)) {
            return;
        }
        if (msg == null) {
            msg = "null";
        }
        if (tag == null) {
            tag = Tag;
        }
        if (type == LogType) {
            Log.d(tag, msg);
        } else {
            loggerD(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (sType == LogType) {
            d(sType, tag, msg);
        } else {
            loggerD(tag, msg);
        }
    }

    public static void d(String msg) {
        if (sType == LogType) {
            d(sTag, msg);
        } else {
            loggerD(sTag, msg);
        }
    }

    private static void loggerD(String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(DebugLevel)) {
            return;
        }
        Logger.init(tag).methodOffset(MethodOffset).methodCount(MethodCount);
        Logger.d(msg);
    }

    public static void i(int type, String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(InfoLevel)) {
            return;
        }
        if (msg == null) {
            msg = "null";
        }
        if (tag == null) {
            tag = Tag;
        }
        if (type == LogType) {
            Log.i(tag, msg);
        } else {
            loggerI(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (sType == LogType) {
            i(sType, tag, msg);
        } else {
            loggerI(tag, msg);
        }
    }

    public static void i(String msg) {
        if (sType == LogType) {
            i(sTag, msg);
        } else {
            loggerI(sTag, msg);
        }
    }

    private static void loggerI(String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(InfoLevel)) {
            return;
        }
        Logger.init(tag).methodOffset(MethodOffset).methodCount(MethodCount);
        Logger.i(msg);
    }


    public static void w(int type, String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(WarnLevel)) {
            return;
        }
        if (msg == null) {
            msg = "null";
        }
        if (tag == null) {
            tag = Tag;
        }
        if (type == LogType) {
            Log.w(tag, msg);
        } else {
            loggerW(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (sType == LogType) {
            w(sType, tag, msg);
        } else {
            loggerW(tag, msg);
        }
    }

    public static void w(String msg) {
        if (sType == LogType) {
            w(sTag, msg);
        } else {
            loggerW(sTag, msg);
        }
    }

    private static void loggerW(String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(WarnLevel)) {
            return;
        }
        Logger.init(tag).methodOffset(MethodOffset).methodCount(MethodCount);
        Logger.w(msg);
    }


    public static void e(int type, String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(ErrorLevel)) {
            return;
        }
        if (msg == null) {
            msg = "null";
        }
        if (tag == null) {
            tag = Tag;
        }
        if (type == LogType) {
            Log.e(tag, msg);
        } else {
            loggerE(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (sType == LogType) {
            e(sType, tag, msg);
        } else {
            loggerE(tag, msg);
        }
    }

    public static void e(String msg) {
        if (sType == LogType) {
            e(sTag, msg);
        } else {
            loggerE(sTag, msg);
        }
    }

    private static void loggerE(String tag, String msg) {
        if (!Debug) {
            return;
        }
        if (!checkLevel(ErrorLevel)) {
            return;
        }
        Logger.init(tag).methodOffset(MethodOffset).methodCount(MethodCount);
        Logger.e(msg);
    }

    public static boolean checkLevel(int level) {
        if ((level == sLgLevel) || (!sOnlyLevel && sLgLevel >= level)) {
            return true;
        }
        return false;
    }

}
