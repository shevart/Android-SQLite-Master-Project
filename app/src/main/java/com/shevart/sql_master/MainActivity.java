package com.shevart.sql_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shevart.sql_master.database.DatabaseManager;
import com.shevart.sql_master.util.MockUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // todo remove this code after test
        DatabaseManager databaseManager = new DatabaseManager(getApplicationContext());
        databaseManager.saveUser(MockUtil.Users.nextUser());
        databaseManager.saveUsersList(MockUtil.Users.nextUsersList());
    }
}
