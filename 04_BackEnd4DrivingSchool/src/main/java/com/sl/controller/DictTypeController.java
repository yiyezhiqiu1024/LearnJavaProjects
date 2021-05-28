package com.sl.controller;

import com.sl.pojo.po.DictType;
import com.sl.pojo.query.DictTypeQuery;
import com.sl.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController {

    @Autowired
    private DictTypeService service;

    @GetMapping
    public Map<String, Object> list(DictTypeQuery query) {
        service.list(query);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "请求成功");
        map.put("count", query.getTotal());
        map.put("data", query.getRecords());
        return map;
    }

    @PostMapping("/remove")
    public Map<String, Object> remove(String id) {
        if (service.removeByIds(Arrays.asList(id.split(",")))) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "删除成功");
            return map;
        } else {
            throw new RuntimeException("删除失败");
        }
    }
}
