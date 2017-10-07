package com.shevart.sql_master.database.with_builders;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.shevart.sql_master.core.AppConfiguration;
import com.shevart.sql_master.database.with_builders.contract.UserContractByBuilders;

class DatabaseByBuildersOpenHelper extends SQLiteOpenHelper {
    DatabaseByBuildersOpenHelper(Context context) {
        super(context, AppConfiguration.DatabaseByBuilders.DATABASE_NAME, null,
                AppConfiguration.DatabaseByBuilders.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create tables
        sqLiteDatabase.execSQL(UserContractByBuilders.Script.Create.CREATE_FROM_BUILDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}