package com.sl.service;

import com.sl.bean.Website;

import java.util.List;

public interface WebsiteService {
    boolean save(Website website);
    List<Website> list();
}
