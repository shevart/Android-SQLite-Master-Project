package com.shevart.sql_master.database.contract;

@SuppressWarnings("WeakerAccess")
public class UserContract extends Contract {
    public static final String TABLE_NAME = "user";
    public static final String NAME = "name";
    public static final String SECOND_NAME = "second_name";
    public static final String EMAIL = "email";
    public static final String BIRTHDAY = "birthday";

    public static class Script {
        public static class Create {
            /***
             *  We can define create table SQLite script manually.
             */
            public static final String CREATE = CREATE_TABLE + TABLE_NAME + OPEN +
                    ID + INTEGER_PRIMARY_KEY + COMMA +
                    NAME + TEXT + COMMA +
                    SECOND_NAME + TEXT + COMMA +
                    EMAIL + TEXT + COMMA +
                    BIRTHDAY + INTEGER + CLOSE;
        }

        public static class Insert {
            public static final String INSERT = INSERT_OR_REPLACE_INTO + TABLE_NAME + OPEN +
                    ID + COMMA +
                    NAME + COMMA +
                    SECOND_NAME + COMMA +
                    EMAIL + COMMA +
                    BIRTHDAY +
                    CLOSE + VALUES + OPEN +
                    "?, ?, ?, ?, ?" + CLOSE;
        }
    }
}