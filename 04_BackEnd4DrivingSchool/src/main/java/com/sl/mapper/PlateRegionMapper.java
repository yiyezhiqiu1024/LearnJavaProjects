package com.sl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sl.pojo.po.PlateRegion;
import com.sl.pojo.vo.list.ProvinceVo;

import java.util.List;

public interface PlateRegionMapper extends BaseMapper<PlateRegion> {
    List<ProvinceVo> selectRegions();
}
