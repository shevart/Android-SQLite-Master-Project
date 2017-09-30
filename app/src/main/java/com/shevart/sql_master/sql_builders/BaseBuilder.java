package com.shevart.sql_master.sql_builders;

import com.shevart.sql_master.base_sql.Contract;

/***
 *  <h3>Developer description</h3>
 *  <br/><br/>
 *  Class-helper for build SQLite scripts
 *  <br/><br/>
 */
@SuppressWarnings("WeakerAccess")
abstract class BaseBuilder {
    static final String COMMA = Contract.COMMA;
    static final String OPEN_BRACKET = Contract.OPEN;
    static final String CLOSE_BRACKET = Contract.CLOSE;
    protected StringBuilder sqlStringBuilder;

    void removeLastComma() {
        sqlStringBuilder.replace(
                sqlStringBuilder.lastIndexOf(COMMA),
                sqlStringBuilder.lastIndexOf(COMMA) + 1
                , "");
    }
}
