package com.shevart.sql_master.database.sql_builders;

import com.shevart.sql_master.util.StringUtils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateTableBuilderTest {
    @Test
    public void createTableSqlErrors() throws Exception {
        final String CREATE_SQL_STATEMENT = CreateTableBuilder
                .createTable("table_name")
                .addIntegerPrimaryKeyColumn("id")
                .addTextColumn("name")
                .toSql();

        assertTrue(!CREATE_SQL_STATEMENT.isEmpty());
        assertTrue(StringUtils.lastSymbolIs(CREATE_SQL_STATEMENT, ')'));
    }

    @Test(expected = RuntimeException.class)
    public void createTableSqlInvalidInputTest() throws Exception {
        CreateTableBuilder.createTable("name")
                .addIntegerPrimaryKeyColumn("id")
                .addIntegerPrimaryKeyColumn("id2")
                .toSql();

    }
}