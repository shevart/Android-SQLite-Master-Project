package com.shevart.sql_master.database.standart.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;

import com.shevart.sql_master.database.common.BaseDao;
import com.shevart.sql_master.database.standart.contract.UserMessagesRelationContract;
import com.shevart.sql_master.models.Message;
import com.shevart.sql_master.models.User;
import com.shevart.sql_master.util.Utils;

public class UserMessagesRelationDao extends BaseDao {
    private UserMessagesRelationDao() {
    }

    public static void saveUserMessagesRelations(@NonNull SQLiteDatabase database,
                                                 @NonNull User user) {
        if (Utils.isNullOrEmpty(user.getMessages())) {
            return;
        }

        final SQLiteStatement statement = database.compileStatement(UserMessagesRelationContract.Script.Insert.INSERT);
        try {
            database.beginTransaction();
            for (Message message : user.getMessages())
                insertUserMessage(statement, user.getId(), message.getId());
            database.setTransactionSuccessful();
        } finally {
            database.setTransactionSuccessful();
        }
    }

    private static void insertUserMessage(@NonNull SQLiteStatement statement,
                                          long userId, long messageId) {
        statement.bindLong(1, userId);
        statement.bindLong(2, messageId);
        statement.executeInsert();
        statement.clearBindings();
    }
}