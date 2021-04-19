package com.sl.service.impl;

import com.sl.bean.Education;
import com.sl.dao.EducationDao;
import com.sl.dao.impl.EducationDaoImpl;
import com.sl.service.EducationService;

import java.util.List;

public class EducationServiceImpl implements EducationService {
    private final EducationDao dao = new EducationDaoImpl();

    @Override
    public List<Education> list() {
        return dao.list();
    }

    @Override
    public boolean save(Education education) {
        return dao.save(education);
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
