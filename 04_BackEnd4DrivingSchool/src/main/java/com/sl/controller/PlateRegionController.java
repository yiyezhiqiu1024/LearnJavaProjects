package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.JsonVos;
import com.sl.pojo.po.PlateRegion;
import com.sl.pojo.vo.DataJsonVo;
import com.sl.pojo.vo.PageJsonVo;
import com.sl.pojo.vo.list.PlateRegionVo;
import com.sl.pojo.vo.req.page.CityPageReqVo;
import com.sl.pojo.vo.req.page.ProvincePageReqVo;
import com.sl.pojo.vo.req.save.PlateRegionReqVo;
import com.sl.service.PlateRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/plateRegions")
public class PlateRegionController extends BaseController<PlateRegion, PlateRegionReqVo> {

    @Autowired
    private PlateRegionService service;

    @Override
    protected IService<PlateRegion> getService() {
        return service;
    }

    @Override
    protected Function<PlateRegionReqVo, PlateRegion> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }

    @GetMapping("provinces")
    public PageJsonVo<PlateRegionVo> provinces(ProvincePageReqVo reqVo) {
        return JsonVos.ok(service.provinces(reqVo));
    }

    @GetMapping("province/list")
    public DataJsonVo<List<PlateRegionVo>> listProvinces() {
        return JsonVos.ok(service.provinces());
    }

    @GetMapping("cities")
    public PageJsonVo<PlateRegionVo> cities(CityPageReqVo reqVo) {
        return JsonVos.ok(service.cities(reqVo));
    }
}
