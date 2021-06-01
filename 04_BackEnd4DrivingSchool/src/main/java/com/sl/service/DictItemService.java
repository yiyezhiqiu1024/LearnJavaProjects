package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.DictItem;
import com.sl.pojo.query.DictItemQuery;

public interface DictItemService extends IService<DictItem> {

    void list(DictItemQuery query);
}
