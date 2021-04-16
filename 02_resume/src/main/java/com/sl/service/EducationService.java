package com.sl.service;

import com.sl.bean.Education;
import com.sl.dao.EducationDao;
import java.util.List;

public class EducationService {
    private EducationDao dao = new EducationDao();

    public List<Education> list() {
        return dao.list();
    }

    public boolean save(Education education) {
        return dao.save(education);
    }

    public boolean remove(List<Integer> ids) {
        return dao.remove(ids);
    }
}
