package com.sl.dao.impl;

import com.sl.bean.Project;
import com.sl.dao.ProjectDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;


public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {

    @Override
    public List<Project> list() {
        String sql = "SELECT id, created_time, intro FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(Project.class));
    }

    @Override
    public boolean save(Project bean) {
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
