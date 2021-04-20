package com.sl.service.impl;

import com.sl.dao.BaseDao;
import com.sl.dao.WebsiteDao;
import com.sl.dao.impl.WebsiteDaoImpl;
import com.sl.service.BaseService;

import java.util.List;


public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private final BaseDao<T> dao = newDao();

    protected abstract BaseDao<T> newDao();

    @Override
    public List<T> list() {
        return dao.list();
    }

    @Override
    public boolean save(T bean) {
        return dao.save(bean);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.remove(id);
    }

    @Override
    public boolean remove(List<Integer> ids) {
        return dao.remove(ids);
    }
}
