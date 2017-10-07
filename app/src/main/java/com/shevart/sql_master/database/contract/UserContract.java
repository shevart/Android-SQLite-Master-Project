package com.shevart.sql_master.database.contract;

import com.shevart.sql_master.database.sql_builders.CreateTableBuilder;

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

            /***
             *  Another way to define create table SQLite script is usage {@link CreateTableBuilder}.
             */
            public static final String CREATE_FROM_BUILDER = CreateTableBuilder
                    .createTable(TABLE_NAME)
                    .addIntegerPrimaryKeyColumn(ID)
                    .addTextColumn(NAME)
                    .addTextColumn(SECOND_NAME)
                    .addTextColumn(EMAIL)
                    .addIntegerColumn(BIRTHDAY)
                    .toSql();
        }
    }

}
