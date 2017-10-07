package com.shevart.sql_master.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.shevart.sql_master.core.AppConfiguration;

class DatabaseOpenHelper extends SQLiteOpenHelper {
    DatabaseOpenHelper(Context context) {
        super(context, AppConfiguration.Database.DATABASE_NAME, null,
                AppConfiguration.Database.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}