package com.shevart.sql_master.database.standart.dao;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.shevart.sql_master.util.LogUtil;

public class DatabaseDemoDao {
    private DatabaseDemoDao() {
    }

    public static void exploreDatabaseMethods(@NonNull SQLiteDatabase database) {
        // Explore database state and info methods
        LogUtil.e("Is database oped: " + database.isOpen());
        LogUtil.e("Database with " + (database.isReadOnly() ? "READ" : "READ_WRITE") + " access permission.");
        LogUtil.e("Database file path is: " + database.getPath());

        LogUtil.e("Database is in transaction: " + database.inTransaction());
        try {
            database.beginTransaction();
            LogUtil.e("Database is in transaction: " + database.inTransaction());
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

    }
}