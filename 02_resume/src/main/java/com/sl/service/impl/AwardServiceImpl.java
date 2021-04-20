package com.sl.service.impl;

import com.sl.bean.Award;
import com.sl.dao.BaseDao;
import com.sl.dao.impl.AwardDaoImpl;
import com.sl.service.AwardService;

public class AwardServiceImpl extends BaseServiceImpl<Award> implements AwardService {
    @Override
    protected BaseDao<Award> newDao() {
        return new AwardDaoImpl();
    }
}
