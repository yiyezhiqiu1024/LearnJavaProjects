package com.sl.dao.impl;

import com.sl.bean.Contact;
import com.sl.dao.ContactDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;


public class ContactDaoImpl extends BaseDaoImpl<Contact> implements ContactDao {

    @Override
    public List<Contact> list() {
        String sql = "SELECT id, created_time, name, email, comment, subject, already_read FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(Contact.class));
    }

    @Override
    public boolean save(Contact bean) {
        Integer id = bean.getId();
        List<Object> args = new ArrayList<>();
        args.add(bean.getName());
        args.add(bean.getEmail());
        args.add(bean.getComment());
        args.add(bean.getSubject());
        args.add(bean.getAlreadyRead());

        String sql;
        if (id == null || id < 1) { // 添加
            sql = "INSERT INTO contact(name, email, comment, subject, already_read) VALUES(?, ?, ?, ?, ?)";
        } else {
            sql = "UPDATE contact SET name = ?, email = ?, comment = ?, subject = ?, already_read = ? WHERE id = ?";
            args.add(id);
        }
        return tpl.update(sql, args.toArray()) > 0;
    }
}
