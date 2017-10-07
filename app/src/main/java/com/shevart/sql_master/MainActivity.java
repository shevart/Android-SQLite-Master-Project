package com.shevart.sql_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shevart.sql_master.database.DatabaseManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // todo remove this code
        DatabaseManager databaseManager = new DatabaseManager(getApplicationContext());


    }
}
