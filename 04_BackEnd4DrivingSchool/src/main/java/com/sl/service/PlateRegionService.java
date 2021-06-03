package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.PlateRegion;
import com.sl.pojo.query.CityQuery;
import com.sl.pojo.query.ProvinceQuery;

import java.util.List;

public interface PlateRegionService extends IService<PlateRegion> {
    void provinces(ProvinceQuery query);
    List<PlateRegion> provinces();
    void cities(CityQuery query);
}
