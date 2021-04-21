package com.sl.service.impl;

import com.sl.bean.Award;
import com.sl.service.AwardService;

import java.util.List;

public class AwardServiceImpl extends BaseServiceImpl<Award> implements AwardService {

    @Override
    public boolean remove(Integer id) {
        // TODO：删除图片文件
        return super.remove(id);
    }

    @Override
    public boolean remove(List<Integer> ids) {
        // TODO: 删除图片文件
        return super.remove(ids);
    }

}
