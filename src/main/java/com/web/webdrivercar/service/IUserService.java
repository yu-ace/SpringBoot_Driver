package com.web.webdrivercar.service;

import com.web.webdrivercar.model.User;

public interface IUserService {
    void register(String name,String password);
    User getUser(String name);
}
