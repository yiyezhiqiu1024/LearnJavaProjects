package com.sl.common.util;

public class Debugs {
    public static final boolean DEBUG = false;

    public static void run(Runnable runnable) {
        if (!DEBUG) return;
        if (runnable == null) return;
        runnable.run();
    }
}
