package com.shevart.sql_master.database.standart;

import android.support.test.runner.AndroidJUnit4;

import com.shevart.sql_master.database.BaseDatabaseTest;
import com.shevart.sql_master.models.User;
import com.shevart.sql_master.util.MockUtil;
import com.shevart.sql_master.utils.ComparatorUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DatabaseManagerTest extends BaseDatabaseTest {

    @Test
    public void saveUser() throws Exception {
        final User originalUser = MockUtil.Users.nextUser();
        final User fromSaveMethodUser = databaseManager.saveUser(originalUser);
        final User fromDatabase = databaseManager.getUserById(originalUser.getId());
        assertTrue(ComparatorUtils.compareUsers(originalUser, fromSaveMethodUser));
        assertTrue(ComparatorUtils.compareUsers(originalUser, fromDatabase));
    }

    @Test
    public void saveUsersList() throws Exception {

    }
}