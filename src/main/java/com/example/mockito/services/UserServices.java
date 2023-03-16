package com.example.mockito.services;

import com.example.mockito.dao.UserDao;
import com.example.mockito.model.User;
public class UserServices {
    private final UserDao userDao;

    public UserServices(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(User user) {
        return userDao.findAllUsers().contains(user);
    }
}


