package com.shevart.sql_master.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

public class DatabaseManager {
    private SQLiteDatabase database;

    public DatabaseManager(@NonNull Context context) {
        DatabaseOpenHelper helper = new DatabaseOpenHelper(context);
        database = helper.getWritableDatabase();
    }
}
