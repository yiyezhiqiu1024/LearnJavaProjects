package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.ExamPlace;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.ExamPlaceVo;
import com.sl.pojo.vo.req.page.ExamPlacePageReqVo;

public interface ExamPlaceService extends IService<ExamPlace> {
    PageVo<ExamPlaceVo> list(ExamPlacePageReqVo reqVo);
}
