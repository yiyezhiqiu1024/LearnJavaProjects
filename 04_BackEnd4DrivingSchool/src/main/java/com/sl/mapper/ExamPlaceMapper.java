package com.sl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sl.pojo.po.ExamPlace;
import com.sl.pojo.vo.list.ExamPlaceVo;

import java.util.List;

public interface ExamPlaceMapper extends BaseMapper<ExamPlace> {
    List<ExamPlaceVo> selectRegionExamPlaces();
}
