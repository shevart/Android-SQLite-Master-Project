package com.shevart.sql_master.database.standart.contract;

import com.shevart.sql_master.database.common.Contract;

@SuppressWarnings("WeakerAccess")
public class UserMessagesRelationContract extends Contract {
    public static final String TABLE_NAME = "user_messages";

    public static final String USER_ID = "user_id";
    public static final String MESSAGE_ID = "message_id";

    public static class Script {
        public static class Create {
            public static final String CREATE = CREATE_TABLE + TABLE_NAME + OPEN +
                    USER_ID + INTEGER + COMMA +
                    MESSAGE_ID + INTEGER + COMMA + CLOSE;
        }

        public static class Insert {
            public static final String INSERT = INSERT_OR_REPLACE_INTO + TABLE_NAME + OPEN +
                    USER_ID + COMMA +
                    MESSAGE_ID + COMMA +
                    CLOSE + VALUES + OPEN +
                    VARIABLE + COMMA + VARIABLE + CLOSE;
        }
    }
}
