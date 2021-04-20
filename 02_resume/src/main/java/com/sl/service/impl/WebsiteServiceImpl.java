package com.sl.service.impl;

import com.sl.bean.Website;
import com.sl.dao.BaseDao;
import com.sl.dao.impl.WebsiteDaoImpl;
import com.sl.service.WebsiteService;

public class WebsiteServiceImpl extends BaseServiceImpl<Website> implements WebsiteService {

    @Override
    protected BaseDao<Website> newDao() {
        return new WebsiteDaoImpl();
    }
}
