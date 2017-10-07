package com.shevart.sql_master.database.with_builders.sql_builders;

import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;

import static com.shevart.sql_master.util.Utils.checkNonNull;
import static com.shevart.sql_master.util.Utils.checkNonNullOrEmpty;
import static com.shevart.sql_master.util.Utils.isNonNullOrEmpty;

/***
 *  <h3>Developer description</h3>
 *  <br/><br/>
 *  Class-wrapper for {@link android.database.sqlite.SQLiteStatement}
 *  <br/><br/>
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class InsertSqlStatementBinder {
    private final SQLiteStatement sqLiteStatement;
    private int count = 0;

    private InsertSqlStatementBinder(@NonNull SQLiteStatement sqLiteStatement) {
        checkNonNull(sqLiteStatement);
        this.sqLiteStatement = sqLiteStatement;
        this.sqLiteStatement.clearBindings();
    }

    public static InsertSqlStatementBinder startBind(@NonNull SQLiteStatement sqLiteStatement) {
        return new InsertSqlStatementBinder(sqLiteStatement);
    }

    public InsertSqlStatementBinder bindString(@NonNull String s) {
        checkNonNullOrEmpty(s);
        sqLiteStatement.bindString(++count, s);
        return this;
    }

    public InsertSqlStatementBinder bindStringEmptySafe(@Nullable String s) {
        if (isNonNullOrEmpty(s)) {
            sqLiteStatement.bindString(++count, "");
        } else {
            sqLiteStatement.bindString(++count, s);
        }
        return this;
    }

    @Deprecated
    public InsertSqlStatementBinder bindStringSafely(@Nullable String s) {
        count++;
        if (!isNonNullOrEmpty(s)) {
            sqLiteStatement.bindString(count, s);
        }
        return this;
    }

    public InsertSqlStatementBinder bindLong(long l) {
        sqLiteStatement.bindLong(++count, l);
        return this;
    }

    public InsertSqlStatementBinder bindDouble(double d) {
        sqLiteStatement.bindDouble(++count, d);
        return this;
    }

    public InsertSqlStatementBinder bindDate(@Nullable Date date) {
        sqLiteStatement.bindLong(++count, date != null ? date.getTime() : 0);
        return this;
    }

    public void executeInsert() {
        sqLiteStatement.executeInsert();
    }
}
