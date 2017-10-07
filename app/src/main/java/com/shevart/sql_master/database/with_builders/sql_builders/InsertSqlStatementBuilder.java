package com.shevart.sql_master.database.with_builders.sql_builders;

import android.support.annotation.NonNull;

import static com.shevart.sql_master.util.Utils.checkNonNullOrEmpty;

/***
 *  <h3>Developer description</h3>
 *  <br/><br/>
 *  Class-helper for build SQLite statement for inserting data to database
 *  <br/><br/>
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class InsertSqlStatementBuilder extends BaseSqlStatementBuilder {
    public static final String INSERT_OR_REPLACE_INTO = "INSERT OR REPLACE INTO ";
    public static final String INSERT_OR_IGNORE_INTO = "INSERT OR IGNORE INTO ";
    public static final String INSERT_INTO = "INSERT INTO ";

    private InsertSqlStatementBuilder(@NonNull String tableName, @NonNull final String INSERT_SQL) {
        checkNonNullOrEmpty(tableName);
        sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append(INSERT_SQL);
        sqlStringBuilder.append(tableName);
        sqlStringBuilder.append(OPEN_BRACKET);
    }

    public static InsertSqlStatementBuilder createInsertSqlStatement(@NonNull String tableName) {
        return new InsertSqlStatementBuilder(tableName, INSERT_INTO);
    }

    public static InsertSqlStatementBuilder createInsertOrReplaceSqlStatement(@NonNull String tableName) {
        return new InsertSqlStatementBuilder(tableName, INSERT_OR_REPLACE_INTO);
    }

    public static InsertSqlStatementBuilder createInsertOrIgnoreSqlStatement(@NonNull String tableName) {
        return new InsertSqlStatementBuilder(tableName, INSERT_OR_IGNORE_INTO);
    }

    public InsertSqlStatementBuilder addColumn(@NonNull String columnName) {
        addColumnToStatement(columnName);
        return this;
    }
}