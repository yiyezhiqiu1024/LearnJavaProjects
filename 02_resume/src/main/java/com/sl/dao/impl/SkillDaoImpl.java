package com.sl.dao.impl;

import com.sl.bean.Skill;
import com.sl.dao.SkillDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends BaseDaoImpl<Skill> implements SkillDao {

    @Override
    public List<Skill> list() {
        String sql = "SELECT id, created_time, name, level FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(Skill.class));
    }

    @Override
    public boolean save(Skill bean) {
        List<Object> args = new ArrayList<>();
        args.add(bean.getName());
        args.add(bean.getLevel());
        Integer id = bean.getId();
        String sql;
        if (id == null || id < 1) { // 添加
            sql = "INSERT INTO " +  table + "(name, level) VALUES (?, ?)";
        } else { // 更新
            sql = "UPDATE " + table + " SET name = ?, level = ?  WHERE id = ?";
            args.add(id);
        }

        return tpl.update(sql, args.toArray()) > 0;
    }



}
