package com.sl.dao.impl;

import com.sl.bean.Website;
import com.sl.dao.WebsiteDao;
import com.sl.util.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class WebsiteDaoImpl implements WebsiteDao {

    @Override
    public boolean save(Website website) {
        List<Object> args = new ArrayList<>();
        args.add(website.getFooter());
        Integer id = website.getId();
        String sql;
        if (id == null || id < 1) { // 添加
            sql = "INSERT INTO website(footer) VALUES (?)";
        } else { // 更新
            sql = "UPDATE website SET footer = ? WHERE id = ?";
            args.add(id);
        }

        return Dbs.getTpl().update(sql, args.toArray()) > 0;
    }

    @Override
    public List<Website> list() {
        String sql = "SELECT id, created_time, footer FROM website";
        return Dbs.getTpl().query(sql, new BeanPropertyRowMapper<>(Website.class));
    }
}
