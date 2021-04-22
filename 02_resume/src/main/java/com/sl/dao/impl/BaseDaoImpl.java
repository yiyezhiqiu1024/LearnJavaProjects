package com.sl.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sl.dao.BaseDao;
import com.sl.util.Strings;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@SuppressWarnings("rawtypes")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    protected static JdbcTemplate tpl;

    static {
        try (InputStream is = BaseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties")) {
            // 获取连接池
            Properties properties = new Properties();
            properties.load(is);
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            // 创建 tpl
            tpl = new JdbcTemplate(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected final String table = newTable();
    protected String newTable() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class beanCls = (Class) type.getActualTypeArguments()[0];
        System.out.println(beanCls.getSimpleName());
        return Strings.underlineCase(beanCls.getSimpleName());
    }

    @Override
    public boolean remove(Integer id) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        return tpl.update(sql, id) > 0;
    }

    @Override
    public boolean remove(List<Integer> ids) {
        List<Object> args = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ").append(table).append(" WHERE id in (");
        for (Integer id : ids) {
            args.add(id);
            sql.append("?, ");
        }
        sql.replace(sql.length() - 2, sql.length(), ")");
        // DELETE FROM table WHERE id in (?, ?, ?)
        return tpl.update(sql.toString(), args.toArray()) > 0;
    }

}
