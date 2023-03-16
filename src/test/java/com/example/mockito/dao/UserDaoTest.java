package com.example.mockito.dao;
import com.example.mockito.dao.impl.UserDaoImpl;
import com.example.mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDaoTest {

    private final UserDao userDao = new UserDaoImpl();


    @Test
    public void testGetUserByName_success() {
        String name = "Vova";
        User user = userDao.getUserByName(name);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(name, user.getName());
    }

    @Test
    public void testGetUserByName_fail() {
        String name = "Steve";
        User user = userDao.getUserByName(name);
        Assertions.assertNull(user);
    }
}




