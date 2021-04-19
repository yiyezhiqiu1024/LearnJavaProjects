package com.sl.dao;

import com.sl.bean.Website;
import java.util.List;

public interface WebsiteDao {
    boolean save(Website website);
    List<Website> list();
}
