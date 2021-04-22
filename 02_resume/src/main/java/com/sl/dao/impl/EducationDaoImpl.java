package com.sl.dao.impl;

import com.sl.bean.Education;
import com.sl.dao.EducationDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class EducationDaoImpl extends BaseDaoImpl<Education> implements EducationDao {

    @Override
    public List<Education> list() {
        String sql = "SELECT id, created_time, name, type, intro, begin_day, end_day FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(Education.class));
    }

    @Override
    public boolean save(Education education) {
        List<Object> args = new ArrayList<>();
        args.add(education.getName());
        args.add(education.getType());
        args.add(education.getIntro());
        args.add(education.getBeginDay());
        args.add(education.getEndDay());
        Integer id = education.getId();
        String sql;
        if (id == null || id < 1) { // 添加
            sql = "INSERT INTO " + table + "(name, type, intro, begin_day, end_day) VALUES (?, ?, ?, ?, ?)";
        } else { // 更新
            sql = "UPDATE " + table + " SET name = ?, type = ?, intro = ?, begin_day = ?, end_day = ? WHERE id = ?";
            args.add(id);
        }

        return tpl.update(sql, args.toArray()) > 0;
    }



}
