package com.shevart.sql_master.database.contract.by_builders;

import com.shevart.sql_master.database.contract.Contract;
import com.shevart.sql_master.database.sql_builders.CreateTableBuilder;
import com.shevart.sql_master.database.sql_builders.InsertSqlStatementBuilder;

@SuppressWarnings("WeakerAccess")
public class UserContractByBuilders extends Contract {
    public static final String TABLE_NAME = "user";
    public static final String NAME = "name";
    public static final String SECOND_NAME = "second_name";
    public static final String EMAIL = "email";
    public static final String BIRTHDAY = "birthday";

    public static class Script {
        public static class Create {
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

        public static class Insert {
            /***
             *  Another way to define insert data script by {@link InsertSqlStatementBuilder}.
             */
            public static final String INSERT_FROM_BUILDER = InsertSqlStatementBuilder
                    .createInsertOrReplaceSqlStatement(TABLE_NAME)
                    .addColumn(ID)
                    .addColumn(NAME)
                    .addColumn(SECOND_NAME)
                    .addColumn(EMAIL)
                    .addColumn(BIRTHDAY)
                    .createSQSqLiteStatement();
        }
    }
}