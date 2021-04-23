package com.sl.service.impl;

import com.sl.bean.User;
import com.sl.dao.UserDao;
import com.sl.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Override
    public User get(User user) {
        return ((UserDao) dao).get(user);
    }
}
