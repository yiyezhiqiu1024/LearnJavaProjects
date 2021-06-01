package com.sl.controller;

import com.sl.common.exception.CommonException;
import com.sl.common.util.Rs;
import com.sl.pojo.po.DictType;
import com.sl.pojo.query.DictTypeQuery;
import com.sl.pojo.result.R;
import com.sl.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController {

    @Autowired
    private DictTypeService service;

    @GetMapping
    public Map<String, Object> list(DictTypeQuery query) {
        service.list(query);
        return Rs.ok(query);
    }

    @PostMapping("/remove")
    public Map<String, Object> remove(String id) {
        if (service.removeByIds(Arrays.asList(id.split(",")))) {
            return Rs.ok("删除成功");
        } else {
            throw new CommonException("删除失败");
        }
    }

    @PostMapping("/save")
    public R save(DictType dictType) {
        if (service.saveOrUpdate(dictType)) {
            return Rs.ok("保存成功");
        } else {
            throw new CommonException("保存失败");
        }
    }
}
