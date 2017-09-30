package com.shevart.sql_master.util;

import android.support.annotation.Nullable;

/**
 * <h3>Developer description</h3>
 * Utility class containing universal null checking methods.
 */
@SuppressWarnings("WeakerAccess")
public class Utils {
    public static void checkNonNull(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
    }

    public static void throwNotSupportMethod() {
        final String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        throw new RuntimeException("Doesn't support -- " + methodName + "() -- method!");
    }

    public static boolean isNonNullOrEmpty(@Nullable String s) {
        return !(s == null || s.isEmpty());
    }

    public static String checkNonNullOrEmpty(@Nullable String s) {
        if (!isNonNullOrEmpty(s)) {
            throw new IllegalArgumentException();
        }
        return s;
    }
}