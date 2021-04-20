package com.sl.service.impl;

import com.sl.bean.Skill;
import com.sl.dao.BaseDao;
import com.sl.dao.impl.SkillDaoImpl;
import com.sl.service.SkillService;


public class SkillServiceImpl extends BaseServiceImpl<Skill> implements SkillService {
    @Override
    protected BaseDao<Skill> newDao() {
        return new SkillDaoImpl();
    }
}
