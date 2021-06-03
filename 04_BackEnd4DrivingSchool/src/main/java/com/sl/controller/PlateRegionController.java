package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.util.Rs;
import com.sl.pojo.po.PlateRegion;
import com.sl.pojo.query.ProvinceQuery;
import com.sl.service.PlateRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/plateRegions")
public class PlateRegionController extends BaseController<PlateRegion> {

    @Autowired
    private PlateRegionService service;

    @Override
    protected IService<PlateRegion> getService() {
        return service;
    }

    @GetMapping("provinces")
    @Transactional(readOnly = true)
    public Map<String, Object> listProvinces(ProvinceQuery query) {
        service.listProvinces(query);
        return Rs.ok(query);
    }
}
