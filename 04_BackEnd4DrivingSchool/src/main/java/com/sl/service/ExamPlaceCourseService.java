package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.ExamPlaceCourse;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.ExamPlaceCourseVo;
import com.sl.pojo.vo.req.page.ExamPlaceCoursePageReqVo;

public interface ExamPlaceCourseService extends IService<ExamPlaceCourse> {
    PageVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo reqVo);
}
