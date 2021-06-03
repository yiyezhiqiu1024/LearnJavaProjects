package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.PlateRegion;
import com.sl.pojo.query.ProvinceQuery;

public interface PlateRegionService extends IService<PlateRegion> {
    void listProvinces(ProvinceQuery query);
}
