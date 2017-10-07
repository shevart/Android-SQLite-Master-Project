package com.shevart.sql_master.database.with_builders;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.shevart.sql_master.database.with_builders.dao.UserDaoByBuilders;
import com.shevart.sql_master.models.User;

// TODO: 07.10.17 add comment-docs
public class DatabaseByBuildersManager {
    private SQLiteDatabase database;

    public DatabaseByBuildersManager(@NonNull Context context) {
        DatabaseByBuildersOpenHelper helper = new DatabaseByBuildersOpenHelper(context);
        database = helper.getWritableDatabase();
    }

    public User saveUser(@NonNull User user) {
        return UserDaoByBuilders.save(database, user);
    }
}