package com.shevart.sql_master.database.sql_builders;

import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
public class SqlStatementBuilder {
    private final SQLiteStatement sqLiteStatement;
    private int count = 0;

    private SqlStatementBuilder(@NonNull SQLiteStatement sqLiteStatement) {
        checkNonNull(sqLiteStatement);
        this.sqLiteStatement = sqLiteStatement;
        this.sqLiteStatement.clearBindings();
    }

    public static SqlStatementBuilder startBind(@NonNull SQLiteStatement sqLiteStatement) {
        return new SqlStatementBuilder(sqLiteStatement);
    }

    public SqlStatementBuilder bindString(@NonNull String s) {
        checkNonNullOrEmpty(s);
        sqLiteStatement.bindString(++count, s);
        return this;
    }

    public SqlStatementBuilder bindStringEmptySafely(@Nullable String s) {
        if (isNonNullOrEmpty(s)) {
            sqLiteStatement.bindString(++count, "");
        } else {
            sqLiteStatement.bindString(++count, s);
        }
        return this;
    }

    @Deprecated
    public SqlStatementBuilder bindStringSafely(@Nullable String s) {
        count++;
        if (!isNonNullOrEmpty(s)) {
            sqLiteStatement.bindString(count, s);
        }
        return this;
    }

    public SqlStatementBuilder bindLong(long l) {
        sqLiteStatement.bindLong(++count, l);
        return this;
    }

    public SqlStatementBuilder bindDouble(double d) {
        sqLiteStatement.bindDouble(++count, d);
        return this;
    }

    public void executeInsert() {
        sqLiteStatement.executeInsert();
    }
}
