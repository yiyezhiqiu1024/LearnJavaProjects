package com.sl.dao.impl;

import com.sl.bean.User;
import com.sl.dao.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public List<User> list() {
        String sql = "SELECT id, created_time, password, email, photo, intro, name, birthday, address, phone, job, trait, interests FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public boolean save(User bean) {
        List<Object> args = new ArrayList<>();
        args.add(bean.getPassword());
        args.add(bean.getEmail());
        args.add(bean.getPhoto());
        args.add(bean.getIntro());
        args.add(bean.getName());
        args.add(bean.getBirthday());
        args.add(bean.getAddress());
        args.add(bean.getPhone());
        args.add(bean.getJob());
        args.add(bean.getTrait());
        args.add(bean.getInterests());
        Integer id = bean.getId();
        String sql;
        if (id == null || id < 1) { // 添加
            sql = "INSERT INTO " + table + "(password, email, photo, intro, name, birthday, address, phone, job, trait, interests) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        } else { // 更新
            sql = "UPDATE " + table + " SET password = ?, email = ?, photo = ?, intro = ?, name = ?, birthday = ?, address = ?, phone = ?, job = ?, trait = ?, interests = ? WHERE id = ?";
            args.add(id);
        }

        return tpl.update(sql, args.toArray()) > 0;
    }

    @Override
    public User get(User user) {
        String sql = "SELECT id, created_time, password, email, phone, intro, name, birthday, address, phone, job, trait, interests FROM " + table + " WHERE email = ? AND password = ?";
        List<User> users = tpl.query(sql, new BeanPropertyRowMapper<>(User.class), user.getEmail(), user.getPassword());
        return users.isEmpty() ? null : users.get(0);
    }
}
