package com.shevart.sql_master.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.shevart.sql_master.models.User;

import java.util.Date;

@SuppressWarnings("WeakerAccess")
public class ComparatorUtils {
    public static boolean compareUsers(@NonNull User first, @NonNull User second) {
        boolean identical = true;

        if (first.getId() != second.getId())
            identical = false;
        if (compareStringNullSafety(first.getName(), second.getName()))
            identical = false;
        if (compareStringNullSafety(first.getSecondName(), second.getSecondName()))
            identical = false;
        if (compareStringNullSafety(first.getEmail(), second.getEmail()))
            identical = false;
        if (compareDateNullSafety(first.getBirthday(), second.getBirthday()))
            identical = false;

        return identical;
    }

    @SuppressWarnings("SimplifiableIfStatement")
    public static boolean compareStringNullSafety(@Nullable String first, @Nullable String second) {
        if (first == null)
            return second == null;
        else if (second == null)
            return false;
        else
            return first.equals(second);
    }

    @SuppressWarnings("SimplifiableIfStatement")
    public static boolean compareDateNullSafety(@Nullable Date first, @Nullable Date second) {
        if (first == null)
            return second == null;
        else if (second == null)
            return false;
        else
            return first.equals(second);
    }
}