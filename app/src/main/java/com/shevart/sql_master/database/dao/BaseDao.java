package com.shevart.sql_master.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/***
 *  <h3>Developer description</h3>
 *  <br/><br/>
 *  Class which define base operations for SQLite
 *  <br/><br/>
 */
@SuppressWarnings("unused")
abstract class BaseDao {
    static boolean parseBoolean(@NonNull Cursor cursor, @NonNull final String KEY) { // 0 (false) and 1 (true)
        return cursor.getInt(cursor.getColumnIndex(KEY)) != 0;
    }

    static int parseInt(@NonNull Cursor cursor, @NonNull final String KEY) {
        return cursor.getInt(cursor.getColumnIndex(KEY));
    }

    static double parseDouble(@NonNull Cursor cursor, @NonNull final String KEY) {
        return cursor.getDouble(cursor.getColumnIndex(KEY));
    }

    static long parseLong(@NonNull Cursor cursor, @NonNull final String KEY) {
        return cursor.getLong(cursor.getColumnIndex(KEY));
    }

    static String parseString(@NonNull Cursor cursor, @NonNull final String KEY) {
        return cursor.getString(cursor.getColumnIndex(KEY));
    }

    static void bindString(@NonNull SQLiteStatement sqLiteStatement, int index, @Nullable String value) {
        if (value != null) sqLiteStatement.bindString(index, value);
    }
}