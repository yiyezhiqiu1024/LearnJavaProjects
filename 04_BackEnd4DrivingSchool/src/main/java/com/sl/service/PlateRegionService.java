package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.PlateRegion;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.PlateRegionVo;
import com.sl.pojo.vo.req.page.CityPageReqVo;
import com.sl.pojo.vo.req.page.ProvincePageReqVo;

import java.util.List;

public interface PlateRegionService extends IService<PlateRegion> {
    PageVo<PlateRegionVo> provinces(ProvincePageReqVo reqVo);
    List<PlateRegionVo> provinces();
    PageVo<PlateRegionVo> cities(CityPageReqVo reqVo);
}
