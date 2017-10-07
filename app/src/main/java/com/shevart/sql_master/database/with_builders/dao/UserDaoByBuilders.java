package com.shevart.sql_master.database.with_builders.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;

import com.shevart.sql_master.database.common.BaseDao;
import com.shevart.sql_master.database.with_builders.contract.UserContractByBuilders;
import com.shevart.sql_master.database.with_builders.sql_builders.InsertSqlStatementBinder;
import com.shevart.sql_master.models.User;

public class UserDaoByBuilders extends BaseDao {
    private UserDaoByBuilders() {
    }

    public static User save(@NonNull SQLiteDatabase database, @NonNull User user) {
        final SQLiteStatement statement = database.compileStatement(UserContractByBuilders.Script.Insert.INSERT_FROM_BUILDER);
        try {
            database.beginTransaction();
            insertUser(statement, user);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return user;
    }

    private static void insertUser(@NonNull SQLiteStatement statement, @NonNull User user) {
        InsertSqlStatementBinder
                .startBind(statement)
                .bindLong(user.getId())
                .bindString(user.getName())
                .bindStringEmptySafe(user.getSecondName())
                .bindString(user.getEmail())
                .bindDate(user.getBirthday())
                .executeInsert();
    }
}