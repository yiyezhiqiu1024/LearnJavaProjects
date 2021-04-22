package com.sl.dao.impl;

import com.sl.bean.Website;
import com.sl.dao.WebsiteDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class WebsiteDaoImpl extends BaseDaoImpl<Website> implements WebsiteDao {

    @Override
    public List<Website> list() {
        String sql = "SELECT id, created_time, footer FROM " + table;
        return tpl.query(sql, new BeanPropertyRowMapper<>(Website.class));
    }

    @Override
    public boolean save(Website website) {
        List<Object> args = new ArrayList<>();
        args.add(website.getFooter());
        Integer id = website.getId();
        String sql;
        if (id == null || id < 1) { // 添加
            sql = "INSERT INTO " + table + "(footer) VALUES (?)";
        } else { // 更新
            sql = "UPDATE " + table + " SET footer = ? WHERE id = ?";
            args.add(id);
        }

        return tpl.update(sql, args.toArray()) > 0;
    }


}
