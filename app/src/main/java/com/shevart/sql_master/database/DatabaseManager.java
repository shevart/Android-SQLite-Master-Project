package com.shevart.sql_master.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.shevart.sql_master.database.dao.UserDao;
import com.shevart.sql_master.models.User;

public class DatabaseManager {
    private SQLiteDatabase database;

    public DatabaseManager(@NonNull Context context) {
        DatabaseOpenHelper helper = new DatabaseOpenHelper(context);
        database = helper.getWritableDatabase();
    }

    public User saveUser(@NonNull User user) {
        return UserDao.saveUser(database, user);
    }
}
