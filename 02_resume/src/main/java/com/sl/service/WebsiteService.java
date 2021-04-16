package com.sl.service;

import com.sl.bean.Website;
import com.sl.dao.WebsiteDao;

import java.util.List;

public class WebsiteService {

    private WebsiteDao dao = new WebsiteDao();

    /**
     * 将 website 保存到数据库
     */
    public boolean save(Website website) {
       return dao.save(website);
    }

    public List<Website> list() {
        return dao.list();
    }
}
