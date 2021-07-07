package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpLambdaQueryWrapper;
import com.sl.common.enhance.MpPage;
import com.sl.common.mapStruct.MapStructs;
import com.sl.mapper.ExamPlaceMapper;
import com.sl.pojo.po.ExamPlace;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.ExamPlaceVo;
import com.sl.pojo.vo.req.page.ExamPlacePageReqVo;
import com.sl.service.ExamPlaceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExamPlaceServiceImpl extends ServiceImpl<ExamPlaceMapper, ExamPlace> implements ExamPlaceService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<ExamPlaceVo> list(ExamPlacePageReqVo reqVo) {
        // 查询条件
        MpLambdaQueryWrapper<ExamPlace> queryWrapper = new MpLambdaQueryWrapper<>();
        // 关键字
        queryWrapper.like(reqVo.getKeyword(), ExamPlace::getName, ExamPlace::getAddress);
        // 城市
        Integer cityId = reqVo.getCityId();
        // 省份
        Integer provinceId = reqVo.getProvinceId();
        if (cityId != null && cityId > 0) {
            queryWrapper.eq(ExamPlace::getCityId, cityId);
        } else if (provinceId != null && provinceId > 0) {
            queryWrapper.ne(ExamPlace::getProvinceId, 0);
        }
        // 按照id降序
        queryWrapper.orderByDesc(ExamPlace::getId);
        // 分页查询
        return baseMapper.selectPage(new MpPage<>(reqVo), queryWrapper).buildVo(MapStructs.INSTANCE::po2vo);
    }
}
