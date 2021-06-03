package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.util.Rs;
import com.sl.pojo.po.PlateRegion;
import com.sl.pojo.query.CityQuery;
import com.sl.pojo.query.ProvinceQuery;
import com.sl.pojo.result.R;
import com.sl.service.PlateRegionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Map<String, Object> provinces(ProvinceQuery query) {
        service.provinces(query);
        return Rs.ok(query);
    }

    @GetMapping("province/list")
    public R listProvinces() {
        return Rs.ok(service.provinces());
    }

    @GetMapping("cities")
    public Map<String, Object> cities(CityQuery query) {
        service.cities(query);
        return Rs.ok(query);
    }
}
