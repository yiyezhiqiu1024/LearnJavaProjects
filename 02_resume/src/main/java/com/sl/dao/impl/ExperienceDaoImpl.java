package com.sl.dao.impl;

import com.sl.bean.Company;
import com.sl.bean.Experience;
import com.sl.dao.ExperienceDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;


public class ExperienceDaoImpl extends BaseDaoImpl<Experience> implements ExperienceDao {
    private static String listSql;
    private static RowMapper<Experience> rowMapper;

    static {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("t1.id, t1.created_time, t1.job, t1.intro, t1.begin_day, t1.end_day, ");
        sql.append("t2.id, t2.created_time, t2.name, t2.logo, t2.website, t2.intro ");
        sql.append("FROM experience t1 JOIN company t2 ON t1.company_id = t2.id");
        listSql = sql.toString();

        rowMapper = (resultSet, i) -> {
            Experience experience = new Experience();
            experience.setId(resultSet.getInt("t1.id"));
            experience.setCreatedTime(resultSet.getDate("t1.created_time"));
            experience.setIntro(resultSet.getString("t1.intro"));
            experience.setJob(resultSet.getString("t1.job"));
            experience.setBeginDay(resultSet.getDate("t1.begin_day"));
            experience.setEndDay(resultSet.getDate("t1.end_day"));

            Company company = new Company();
            company.setId(resultSet.getInt("t2.id"));
            company.setCreatedTime(resultSet.getDate("t2.created_time"));
            company.setIntro(resultSet.getString("t2.intro"));
            company.setLogo(resultSet.getString("t2.logo"));
            company.setWebsite(resultSet.getString("t2.website"));
            company.setName(resultSet.getString("t2.name"));

            experience.setCompany(company);

            return experience;
        };
    }

    @Override
    public List<Experience> list() {
        return tpl.query(listSql, rowMapper);
    }

    @Override
    public boolean save(Experience bean) {
        List<Object> args = new ArrayList<>();
        args.add(bean.getJob());
        args.add(bean.getIntro());
        args.add(bean.getBeginDay());
        args.add(bean.getEndDay());
        args.add(bean.getCompany().getId());
        Integer id = bean.getId();
        String sql;
        if (id == null || id < 1) { // 添加
            sql = "INSERT INTO " + table + "(job, intro, begin_day, end_day, company_id) VALUES (?, ?, ?, ?, ?)";
        } else { // 更新
            sql = "UPDATE " + table + " SET job = ?, intro = ?, begin_day = ?, end_day = ?, company_id = ? WHERE id = ?";
            args.add(id);
        }

        return tpl.update(sql, args.toArray()) > 0;
    }
}
