package com.shevart.sql_master.util;

import com.shevart.sql_master.models.User;

import java.util.ArrayList;
import java.util.List;

public class MockUtil {
    private static final List<String> names = new ArrayList<>();
    private static final List<String> secondNames = new ArrayList<>();

    static {
        names.add("John");
        names.add("Peter");
        names.add("Diana");
        names.add("Artur");
        names.add("Jessica");
        names.add("George");
        names.add("Donald");
        names.add("Daniel");
        names.add("David");
        names.add("Johny");

        secondNames.add("Smith");
        secondNames.add("Johnson");
        secondNames.add("Williams");
        secondNames.add("Jones");
        secondNames.add("Brown");
        secondNames.add("Davis");
        secondNames.add("Miller");
    }

    public static class Users {
        private static long id = 0;

        public static User nextUser() {
            User user = new User();
            user.setId(++id);
            return user;
        }
    }
}
