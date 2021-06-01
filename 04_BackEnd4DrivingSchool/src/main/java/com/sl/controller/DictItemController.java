package com.sl.controller;

import com.sl.common.exception.CommonException;
import com.sl.common.util.Rs;
import com.sl.pojo.po.DictItem;
import com.sl.pojo.query.DictItemQuery;
import com.sl.pojo.result.R;
import com.sl.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/dictItems")
public class DictItemController {

    @Autowired
    private DictItemService service;

    @GetMapping
    public Map<String, Object> list(DictItemQuery query) {
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
    public R save(DictItem DictItem) {
        if (service.saveOrUpdate(DictItem)) {
            return Rs.ok("保存成功");
        } else {
            throw new CommonException("保存失败");
        }
    }
}
