package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.util.Rs;
import com.sl.pojo.po.DictType;
import com.sl.pojo.query.DictTypeQuery;
import com.sl.pojo.result.R;
import com.sl.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController extends BaseController<DictType> {

    @Autowired
    private DictTypeService service;

    @Override
    protected IService<DictType> getService() {
        return service;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public Map<String, Object> list(DictTypeQuery query) {
        service.list(query);
        return Rs.ok(query);
    }

    @GetMapping("/list")
    @Transactional(readOnly = true)
    public R list() {
        return Rs.ok(service.list());
    }
}
