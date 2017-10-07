package com.shevart.sql_master.core;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class SQLiteMasterApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /*
         * Stetho - library which allow us to see database scheme with Google Chrome Browser.
         * See http://facebook.github.io/stetho/ - for more details.
         */
        Stetho.initializeWithDefaults(this);
    }
}
