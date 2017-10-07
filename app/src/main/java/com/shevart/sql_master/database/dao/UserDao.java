package com.shevart.sql_master.database.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;

import com.shevart.sql_master.database.contract.UserContract;
import com.shevart.sql_master.models.User;

@SuppressWarnings("unused")
public class UserDao extends BaseDao {
    private UserDao() {
    }

    public static User saveUser(@NonNull SQLiteDatabase database, @NonNull User user) {
        final SQLiteStatement statement = database.compileStatement(UserContract.Script.Insert.INSERT);
        try {
            database.beginTransaction();
            bindInsert(statement, user);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return user;
    }

    private static void bindInsert(@NonNull SQLiteStatement statement, @NonNull User user) {
        statement.bindLong(1, user.getId());
        bindString(statement, 2, user.getName());
        bindString(statement, 3, user.getSecondName());
        bindString(statement, 4, user.getEmail());
        bindDate(statement, 5, user.getBirthday());
        statement.executeInsert();
        statement.clearBindings();
    }
}