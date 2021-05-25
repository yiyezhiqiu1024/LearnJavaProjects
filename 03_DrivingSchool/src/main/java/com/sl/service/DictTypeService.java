package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.DictType;
import com.sl.pojo.query.DictTypeQuery;

import java.util.List;

public interface DictTypeService extends IService<DictType> {

    List<DictType> list(DictTypeQuery query);
}
