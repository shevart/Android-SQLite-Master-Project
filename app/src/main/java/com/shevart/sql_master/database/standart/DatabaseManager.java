package com.shevart.sql_master.database.standart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.shevart.sql_master.database.standart.dao.DatabaseDemoDao;
import com.shevart.sql_master.database.standart.dao.UserDao;
import com.shevart.sql_master.models.User;

import java.util.List;

// TODO: 07.10.17 add comment-docs
public class DatabaseManager {
    private SQLiteDatabase database;

    public DatabaseManager(@NonNull Context context) {
        DatabaseOpenHelper helper = new DatabaseOpenHelper(context);
        database = helper.getWritableDatabase();
    }

    public void demoDatabaseMethods() {
        DatabaseDemoDao.exploreDatabaseMethods(database);
    }

    public User saveUser(@NonNull User user) {
        return UserDao.save(database, user);
    }

    public List<User> saveUsersList(@NonNull List<User> users) {
        return UserDao.save(database, users);
    }
}