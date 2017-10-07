package com.shevart.sql_master.database.dao;

import android.support.annotation.NonNull;

import com.shevart.sql_master.models.User;

@SuppressWarnings("unused")
public class UserDao {
    private UserDao() {
    }

    public static User saveUser(@NonNull User user) {

        return user;
    }
}