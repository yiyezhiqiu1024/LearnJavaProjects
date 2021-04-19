package com.sl.service.impl;

import com.sl.bean.Website;
import com.sl.dao.WebsiteDao;
import com.sl.dao.impl.WebsiteDaoImpl;
import com.sl.service.WebsiteService;

import java.util.List;

public class WebsiteServiceImpl implements WebsiteService {

    private final WebsiteDao dao = new WebsiteDaoImpl();

    @Override
    public boolean save(Website website) {
        return dao.save(website);
    }

    @Override
    public List<Website> list() {
        return dao.list();
    }
}
