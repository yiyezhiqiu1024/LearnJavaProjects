package com.sl.dao.impl;

import com.sl.bean.Experience;
import com.sl.dao.ExperienceDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;


public class ExperienceDaoImpl extends BaseDaoImpl<Experience> implements ExperienceDao {

    @Override
    public List<Experience> list() {
        String sql = "SELECT id, created_time, intro FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(Experience.class));
    }

    @Override
    public boolean save(Experience bean) {
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
