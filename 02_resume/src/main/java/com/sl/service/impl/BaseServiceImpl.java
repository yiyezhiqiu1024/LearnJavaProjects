package com.sl.service.impl;

import com.sl.dao.BaseDao;
import com.sl.service.BaseService;

import java.util.List;

@SuppressWarnings("unchecked")
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected final BaseDao<T> dao = newDao();
    protected BaseDao<T> newDao() {
        // com.sl.service.impl.WebsiteServiceImpl
        // com.sl.dao.impl.WebsiteDaoImpl
        String clsName = getClass().getName().replace(".service", ".dao").replace("Service", "Dao");
        try {
            return (BaseDao<T>) Class.forName(clsName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
