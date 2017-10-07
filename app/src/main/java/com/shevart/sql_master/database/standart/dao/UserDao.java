package com.shevart.sql_master.database.standart.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;

import com.shevart.sql_master.database.common.BaseDao;
import com.shevart.sql_master.database.standart.contract.UserContract;
import com.shevart.sql_master.models.User;

import java.util.List;

@SuppressWarnings("unused")
public class UserDao extends BaseDao {
    private UserDao() {
    }

    public static User save(@NonNull SQLiteDatabase database, @NonNull User user) {
        final SQLiteStatement statement = database.compileStatement(UserContract.Script.Insert.INSERT);
        try {
            database.beginTransaction();
            insertUser(statement, user);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return user;
    }

    public static List<User> save(@NonNull SQLiteDatabase database, @NonNull List<User> users) {
        final SQLiteStatement statement = database.compileStatement(UserContract.Script.Insert.INSERT);
        try {
            database.beginTransaction();
            for (User user : users) {
                insertUser(statement, user);
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return users;
    }

    private static void insertUser(@NonNull SQLiteStatement statement, @NonNull User user) {
        statement.bindLong(1, user.getId());
        bindString(statement, 2, user.getName());
        bindString(statement, 3, user.getSecondName());
        bindString(statement, 4, user.getEmail());
        bindDate(statement, 5, user.getBirthday());
        statement.executeInsert();
        statement.clearBindings();
    }
}