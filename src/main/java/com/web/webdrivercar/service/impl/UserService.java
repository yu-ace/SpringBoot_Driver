package com.web.webdrivercar.service.impl;

import com.web.webdrivercar.dao.UserDao;
import com.web.webdrivercar.model.User;
import com.web.webdrivercar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public void register(String name, String password) {
        userDao.register(name,password);
    }

    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
    }
}
