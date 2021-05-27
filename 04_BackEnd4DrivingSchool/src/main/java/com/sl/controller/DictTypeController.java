package com.sl.controller;

import com.sl.pojo.po.DictType;
import com.sl.pojo.query.DictTypeQuery;
import com.sl.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController {

    @Autowired
    private DictTypeService service;

    @GetMapping("/list")
    public Map<String, Object> list(DictTypeQuery query) {
        service.list(query);
        List<DictType> records = query.getRecords();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "请求成功");
        map.put("count", records.size());
        map.put("data", records);
        return map;
    }
}
