package com.shevart.sql_master.util;

import android.support.annotation.NonNull;

import com.shevart.sql_master.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MockUtil {
    private static final String EMAIL_PATTERN = "%s@%s";
    private static final List<String> names = new ArrayList<>();
    private static final List<String> secondNames = new ArrayList<>();
    private static final List<String> emailDomains = new ArrayList<>();
    private static Random random = new Random();

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
        secondNames.add("Wilson");
        secondNames.add("Moore");
        secondNames.add("Taylor");

        emailDomains.add("gmail.com");
        emailDomains.add("icloud.com");
        emailDomains.add("yandex.ru");
    }

    private static String nextName() {
        return names.get(random.nextInt(names.size()));
    }

    private static String nextSecondName() {
        return secondNames.get(random.nextInt(secondNames.size()));
    }

    private static String nextEmail(@NonNull String name) {
        return String.format(Locale.ENGLISH, EMAIL_PATTERN, name,
                emailDomains.get(random.nextInt(emailDomains.size())));
    }

    @SuppressWarnings("WeakerAccess")
    public static class Users {
        private static long id = 0;

        public static List<User> nextUsersList() {
            final List<User> userList = new ArrayList<>();
            for (int i = 0; i < 25; i++) {
                userList.add(nextUser());
            }
            return userList;
        }

        public static User nextUser() {
            User user = new User();
            user.setId(++id);
            user.setName(nextName());
            user.setSecondName(nextSecondName());
            user.setEmail(nextEmail(user.getName()));
            user.setBirthday(new Date());
            return user;
        }
    }
}