package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.util.Rs;
import com.sl.pojo.po.DictItem;
import com.sl.pojo.query.DictItemQuery;
import com.sl.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/dictItems")
public class DictItemController extends BaseController<DictItem> {

    @Autowired
    private DictItemService service;

    @Override
    protected IService<DictItem> getService() {
        return service;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public Map<String, Object> list(DictItemQuery query) {
        service.list(query);
        return Rs.ok(query);
    }
}
