package com.shevart.sql_master.database.sql_builders;

import android.support.annotation.NonNull;

import com.shevart.sql_master.database.base_sql.Contract;

import static com.shevart.sql_master.util.Utils.checkNonNullOrEmpty;

/***
 *  <h3>Developer description</h3>
 *  <br/><br/>
 *  Class-helper for build SQLite statement for creating tables
 *  <br/><br/>
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class CreateTableBuilder extends BaseBuilder {
    private static final String CREATE_TABLE = "CREATE TABLE ";
    private boolean isPrimaryKeyAlreadyDefined = false;

    private CreateTableBuilder(@NonNull final String tableName) {
        checkNonNullOrEmpty(tableName);
        sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append(CREATE_TABLE);
        sqlStringBuilder.append(tableName);
        sqlStringBuilder.append(OPEN_BRACKET);
    }

    public static CreateTableBuilder createTable(@NonNull String tableName) {
        return new CreateTableBuilder(tableName);
    }

    public CreateTableBuilder addIntegerPrimaryKeyColumn(@NonNull String columnName) {
        if (isPrimaryKeyAlreadyDefined)
            throw new RuntimeException("Primary key cannot be more than one!");
        isPrimaryKeyAlreadyDefined = true;
        sqlStringBuilder.append(columnName);
        sqlStringBuilder.append(Contract.INTEGER_PRIMARY_KEY);
        sqlStringBuilder.append(COMMA);
        return this;
    }

    public CreateTableBuilder addIntegerPrimaryKeyColumnAutoincrement(@NonNull String columnName) {
        if (isPrimaryKeyAlreadyDefined)
            throw new RuntimeException("Primary key cannot be more than one!");
        isPrimaryKeyAlreadyDefined = true;
        sqlStringBuilder.append(columnName);
        sqlStringBuilder.append(Contract.INTEGER_PRIMARY_KEY_AUTOINCREMENT);
        sqlStringBuilder.append(COMMA);
        return this;
    }

    public CreateTableBuilder addIntegerColumn(@NonNull String columnName) {
        sqlStringBuilder.append(columnName);
        sqlStringBuilder.append(Contract.INTEGER);
        sqlStringBuilder.append(COMMA);
        return this;
    }

    public CreateTableBuilder addTextColumn(@NonNull String columnName) {
        sqlStringBuilder.append(columnName);
        sqlStringBuilder.append(Contract.TEXT);
        sqlStringBuilder.append(COMMA);
        return this;
    }

    public CreateTableBuilder addTextColumnPrimaryKey(@NonNull String columnName) {
        sqlStringBuilder.append(columnName);
        sqlStringBuilder.append(Contract.TEXT_PRIMARY_KEY);
        sqlStringBuilder.append(COMMA);
        return this;
    }

    public CreateTableBuilder addRealColumn(@NonNull String columnName) {
        sqlStringBuilder.append(columnName);
        sqlStringBuilder.append(Contract.REAL);
        sqlStringBuilder.append(COMMA);
        return this;
    }

    public String toSql() {
        removeLastComma();
        sqlStringBuilder.append(CLOSE_BRACKET);
        return sqlStringBuilder.toString();
    }
}