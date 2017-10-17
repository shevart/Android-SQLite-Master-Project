package com.shevart.sql_master.database;

import android.support.test.InstrumentationRegistry;

import com.shevart.sql_master.core.AppConfiguration;
import com.shevart.sql_master.database.standart.DatabaseManager;

import org.junit.After;
import org.junit.Before;

import static junit.framework.Assert.assertTrue;

@SuppressWarnings("WeakerAccess")
public class BaseDatabaseTest {
    protected DatabaseManager databaseManager;

    @Before
    public void setUp() {
        databaseManager = new DatabaseManager(InstrumentationRegistry.getTargetContext());
    }

    @After
    public void shutDown() {
        assertTrue(InstrumentationRegistry.getTargetContext().deleteDatabase(AppConfiguration
                .Database.DATABASE_NAME));
    }


}
