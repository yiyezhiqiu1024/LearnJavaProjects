package com.sl.dao.impl;

import com.sl.bean.#0#;
import com.sl.dao.#0#Dao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;


public class #0#DaoImpl extends BaseDaoImpl<#0#> implements #0#Dao {

    @Override
    public List<#0#> list() {
        String sql = "SELECT id, created_time, name FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(#0#.class));
    }

    @Override
    public boolean save(#0# bean) {
        List<Object> args = new ArrayList<>();\

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
