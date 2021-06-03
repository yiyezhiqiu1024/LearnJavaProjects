package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.promeg.pinyinhelper.Pinyin;
import com.sl.common.enhance.MpPage;
import com.sl.common.enhance.MpQueryWrapper;
import com.sl.mapper.PlateRegionMapper;
import com.sl.pojo.po.PlateRegion;
import com.sl.pojo.query.ProvinceQuery;
import com.sl.service.PlateRegionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlateRegionServiceImpl extends ServiceImpl<PlateRegionMapper, PlateRegion> implements PlateRegionService {

    @Override
    public boolean save(PlateRegion entity) {
        processPinyin(entity);
        return super.save(entity);
    }

    @Override
    public boolean updateById(PlateRegion entity) {
        processPinyin(entity);
        return super.updateById(entity);
    }

    private void processPinyin(PlateRegion region) {
        String name = region.getName();
        if (name == null) return;
        region.setPinyin(Pinyin.toPinyin(name, "_"));
    }


    @Override
    @Transactional(readOnly = true)
    public void listProvinces(ProvinceQuery query) {
        // 查询条件
        MpQueryWrapper<PlateRegion> queryWrapper = new MpQueryWrapper<>();
        // 关键字
        queryWrapper.like(query.getKeyword(), PlateRegion::getName, PlateRegion::getPlate, PlateRegion::getPinyin);
        // 所有省份
        queryWrapper.eq(PlateRegion::getParentId, 0);
        // 按照id降序
        queryWrapper.orderByDesc(PlateRegion::getId);
        // 分页查询
        baseMapper.selectPage(new MpPage<>(query), queryWrapper).updateQuery();
    }
}
