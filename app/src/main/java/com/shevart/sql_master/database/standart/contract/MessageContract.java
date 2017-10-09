package com.shevart.sql_master.database.standart.contract;

import com.shevart.sql_master.database.common.Contract;

@SuppressWarnings("WeakerAccess")
public class MessageContract extends Contract {
    public static final String TABLE_NAME = "messages";

    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String CREATED_AT = "created_at";

    public static class Script {
        public static class Create {
            public static final String CREATE = CREATE_TABLE + TABLE_NAME + OPEN +
                    ID + INTEGER_PRIMARY_KEY_AUTOINCREMENT + COMMA +
                    TITLE + TEXT + COMMA +
                    DESCRIPTION + TEXT + COMMA +
                    CREATED_AT + INTEGER + CLOSE;
        }
    }
}