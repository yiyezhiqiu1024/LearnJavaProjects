package com.sl.dao;

import com.sl.bean.Education;
import com.sl.bean.Website;
import com.sl.util.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class EducationDao {

    public List<Education> list() {
        String sql = "SELECT id, created_time, name, type, intro, begin_day, end_day FROM education";
        return Dbs.getTpl().query(sql, new BeanPropertyRowMapper<>(Education.class));
    }

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
            sql = "INSERT INTO education(name, type, intro, begin_day, end_day) VALUES (?, ?, ?, ?, ?)";
        } else { // 更新
            sql = "UPDATE education SET name = ?, type = ?, intro = ?, begin_day = ?, end_day = ? WHERE id = ?";
            args.add(id);
        }

        return Dbs.getTpl().update(sql, args.toArray()) > 0;
    }

    public boolean remove(Integer id) {
        String sql = "DELETE FROM education WHERE id = ?";
        return Dbs.getTpl().update(sql, id) > 0;
    }
}
