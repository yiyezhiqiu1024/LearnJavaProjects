package com.sl.dao;

import com.sl.bean.User;

public interface UserDao extends BaseDao<User> {
    User get(User user);
}
