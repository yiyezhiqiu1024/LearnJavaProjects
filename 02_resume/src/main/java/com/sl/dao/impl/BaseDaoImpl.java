package com.sl.dao.impl;

import com.sl.dao.BaseDao;
import com.sl.util.Dbs;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private final String table = newTable();
    protected abstract String newTable();

    @Override
    public boolean remove(Integer id) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        return Dbs.getTpl().update(sql, id) > 0;
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
        return Dbs.getTpl().update(sql.toString(), args.toArray()) > 0;
    }
}
