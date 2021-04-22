package com.sl.dao.impl;

import com.sl.bean.User;
import com.sl.dao.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public List<User> list() {
        String sql = "SELECT id, created_time, intro FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public boolean save(User bean) {
        List<Object> args = new ArrayList<>();

        Integer id = bean.getId();
        String sql;
        if (id == null || id < 1) { // 添加
            sql = "INSERT INTO " + table + "(name) VALUES (?)";
        } else { // 更新
            sql = "UPDATE " + table + " SET name = ? WHERE id = ?";
            args.add(id);
        }

        return tpl.update(sql, args.toArray()) > 0;
    }
}
