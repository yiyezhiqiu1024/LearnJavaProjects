package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.DictType;
import com.sl.pojo.query.DictTypeQuery;

public interface DictTypeService extends IService<DictType> {

    void list(DictTypeQuery query);
}
