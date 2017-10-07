package com.shevart.sql_master.util;

import android.support.annotation.NonNull;

public class StringUtils {
    public static boolean lastSymbolIs(@NonNull String s, char symbol) {
        return s.charAt(s.length() - 1) == symbol;
    }
}