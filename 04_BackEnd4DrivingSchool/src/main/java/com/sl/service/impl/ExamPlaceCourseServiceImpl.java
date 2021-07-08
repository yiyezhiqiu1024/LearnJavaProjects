package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpPage;
import com.sl.common.enhance.MpQueryWrapper;
import com.sl.mapper.ExamPlaceCourseMapper;
import com.sl.pojo.po.ExamPlaceCourse;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.ExamPlaceCourseVo;
import com.sl.pojo.vo.req.page.ExamPlaceCoursePageReqVo;
import com.sl.service.ExamPlaceCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExamPlaceCourseServiceImpl extends ServiceImpl<ExamPlaceCourseMapper, ExamPlaceCourse> implements ExamPlaceCourseService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo reqVo) {
        // 查询条件
        MpQueryWrapper<ExamPlaceCourseVo> queryWrapper = new MpQueryWrapper<>();
        Integer placeId = reqVo.getPlaceId();
        Integer provinceId = reqVo.getProvinceId();
        Integer cityId = reqVo.getCityId();
        Short type = reqVo.getType();
        // 类型
        if (type != null && type >= 0) {
            queryWrapper.eq("c.type", type);
        }

        // 考场 -> 城市 -> 省份
        if (placeId != null && placeId > 0) {
            queryWrapper.eq("c.place_id", placeId);
        } else if (cityId != null && cityId > 0) {
            queryWrapper.eq("p.city_id", cityId);
        } else if (provinceId != null && provinceId > 0) {
            queryWrapper.eq("p.province_id", provinceId);
        }

        // 关键词
        queryWrapper.like(reqVo.getKeyword(), "c.name", "c.intro");
        return baseMapper
                .selectPageVos(new MpPage<>(reqVo), queryWrapper)
                .buildVo();

        // SELECT COUNT(*) FROM exam_place_course c WHERE (province_id = ?)
        // SELECT COUNT(*) FROM exam_place_course c WHERE (city_id = ?)

//        MpQueryWrapper<ExamPlaceCourseVo> queryWrapper = new MpQueryWrapper<>();
//        Integer placeId = query.getPlaceId();
//        Integer provinceId = query.getProvinceId();
//        Integer cityId = query.getCityId();
//        Short type = query.getType();
//        // 类型
//        if (type != null && type >= 0) {
//            queryWrapper.eq(ExamPlaceCourseVo::getType, type);
//        }
//        // 考场 -> 城市 -> 省份
//        if (placeId != null && placeId > 0) {
//            queryWrapper.eq(ExamPlaceCourseVo::getPlaceId, placeId);
//        } else  if (cityId != null && cityId > 0) {
//            queryWrapper.eq(ExamPlaceCourseVo::getCityId, cityId);
//        } else if (provinceId != null && provinceId > 0) {
//            queryWrapper.eq(ExamPlaceCourseVo::getProvinceId, provinceId);
//        }
//        // 关键词
//        queryWrapper.like(query.getKeyword(), ExamPlaceCourseVo::getName, ExamPlaceCourseVo::getIntro);
//        return baseMapper
//                .selectPageVos(new MpPage<>(queryWrapper), wrapper)
//                .buildVo();
        // 通过province_id查询时：Unknown column 'province_id' in 'where clause'
        // 通过province_id查询时：Unknown column 'city_id' in 'where clause'
        // 通过name查询时：Column 'name' in where clause is ambiguous
    }
}
