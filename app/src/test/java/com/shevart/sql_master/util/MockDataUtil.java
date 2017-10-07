package com.shevart.sql_master.util;

import com.shevart.sql_master.models.User;

import java.util.Date;

public class MockDataUtil {
    public static User getMockUser() {
        User user = new User();
        user.setId(1);
        user.setName("userName");
        user.setSecondName("userSecondName");
        user.setEmail("email");
        user.setBirthday(new Date());
        return user;
    }
}
