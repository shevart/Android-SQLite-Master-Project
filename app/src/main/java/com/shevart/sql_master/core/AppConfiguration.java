package com.shevart.sql_master.core;

/**
 * <h3>Developer comment</h3>
 * This class contains application-level constants and params (for ex. Database version)
 */

public class AppConfiguration {
    public static class Database {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "sqlite-master";
    }

    public static class DatabaseByBuilders {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "sqlite-master_builders";
    }
}