package com.sl.service.impl;

import com.sl.bean.Education;
import com.sl.dao.BaseDao;
import com.sl.dao.impl.EducationDaoImpl;
import com.sl.service.EducationService;


public class EducationServiceImpl extends BaseServiceImpl<Education> implements EducationService {
    @Override
    protected BaseDao<Education> newDao() {
        return new EducationDaoImpl();
    }
}
