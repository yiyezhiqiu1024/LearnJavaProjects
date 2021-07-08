package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.JsonVos;
import com.sl.pojo.po.ExamPlaceCourse;
import com.sl.pojo.vo.PageJsonVo;
import com.sl.pojo.vo.list.ExamPlaceCourseVo;
import com.sl.pojo.vo.req.page.ExamPlaceCoursePageReqVo;
import com.sl.pojo.vo.req.save.ExamPlaceCourseReqVo;
import com.sl.service.ExamPlaceCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/examPlaceCourses")
@Api(tags = "科2科3课程")
public class ExamPlaceCourseController extends BaseController<ExamPlaceCourse, ExamPlaceCourseReqVo> {

    @Autowired
    private ExamPlaceCourseService service;

    @Override
    protected IService<ExamPlaceCourse> getService() {
        return service;
    }

    @Override
    protected Function<ExamPlaceCourseReqVo, ExamPlaceCourse> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<ExamPlaceCourseVo> list(ExamPlaceCoursePageReqVo reqVo) {
        return JsonVos.ok(service.list(reqVo));
    }
}
