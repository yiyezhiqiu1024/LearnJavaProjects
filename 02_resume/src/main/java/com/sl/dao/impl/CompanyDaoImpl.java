package com.sl.dao.impl;

import com.sl.bean.Company;
import com.sl.dao.CompanyDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;


public class CompanyDaoImpl extends BaseDaoImpl<Company> implements CompanyDao {

    @Override
    public List<Company> list() {
        String sql = "SELECT id, created_time, intro FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(Company.class));
    }

    @Override
    public boolean save(Company bean) {
        List<Object> args = new ArrayList<>();
        args.add(bean.getName());
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
