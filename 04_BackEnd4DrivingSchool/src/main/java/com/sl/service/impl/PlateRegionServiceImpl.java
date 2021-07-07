package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.promeg.pinyinhelper.Pinyin;
import com.sl.common.enhance.MpPage;
import com.sl.common.enhance.MpLambdaQueryWrapper;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.Streams;
import com.sl.mapper.PlateRegionMapper;
import com.sl.pojo.po.PlateRegion;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.PlateRegionVo;
import com.sl.pojo.vo.list.ProvinceVo;
import com.sl.pojo.vo.req.page.CityPageReqVo;
import com.sl.pojo.vo.req.page.ProvincePageReqVo;
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
    public PageVo<PlateRegionVo> provinces(ProvincePageReqVo reqVo) {
        // 查询条件
        MpLambdaQueryWrapper<PlateRegion> queryWrapper = new MpLambdaQueryWrapper<>();
        // 关键字
        queryWrapper.like(reqVo.getKeyword(), PlateRegion::getName, PlateRegion::getPlate, PlateRegion::getPinyin);
        // 所有省份
        queryWrapper.eq(PlateRegion::getParentId, 0);
        // 按照id降序
        queryWrapper.orderByDesc(PlateRegion::getId);
        // 分页查询
        return baseMapper.selectPage(new MpPage<>(reqVo), queryWrapper).buildVo(MapStructs.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlateRegionVo> provinces() {
        MpLambdaQueryWrapper<PlateRegion> queryWrapper = new MpLambdaQueryWrapper<>();
        queryWrapper.eq(PlateRegion::getParentId, 0);
        queryWrapper.orderByAsc(PlateRegion::getPinyin);
        return Streams.map(baseMapper.selectList(queryWrapper), MapStructs.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public PageVo<PlateRegionVo> cities(CityPageReqVo reqVo) {
        // 查询条件
        MpLambdaQueryWrapper<PlateRegion> queryWrapper = new MpLambdaQueryWrapper<>();
        // 关键字
        queryWrapper.like(reqVo.getKeyword(), PlateRegion::getName, PlateRegion::getPlate, PlateRegion::getPinyin);
        Integer parentId = reqVo.getParentId();
        if (parentId != null && parentId > 0) { // parentId下面的所有城市
            queryWrapper.eq(PlateRegion::getParentId, parentId);
        } else { // 所有城市
            queryWrapper.ne(PlateRegion::getParentId, 0);
        }
        // 按照id降序
        queryWrapper.orderByDesc(PlateRegion::getId);
        // 分页查询
        return baseMapper.selectPage(new MpPage<>(reqVo), queryWrapper).buildVo(MapStructs.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProvinceVo> regions() {
        return baseMapper.selectRegions();
    }
}
