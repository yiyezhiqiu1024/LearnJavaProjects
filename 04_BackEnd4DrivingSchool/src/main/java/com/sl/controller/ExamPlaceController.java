package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.JsonVos;
import com.sl.pojo.po.ExamPlace;
import com.sl.pojo.vo.PageJsonVo;
import com.sl.pojo.vo.list.ExamPlaceVo;
import com.sl.pojo.vo.req.page.ExamPlacePageReqVo;
import com.sl.pojo.vo.req.save.ExamPlaceReqVo;
import com.sl.service.ExamPlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/examPlaces")
@Api(tags = "考场")
public class ExamPlaceController extends BaseController<ExamPlace, ExamPlaceReqVo> {

    @Autowired
    private ExamPlaceService service;

    @Override
    protected IService<ExamPlace> getService() {
        return service;
    }

    @Override
    protected Function<ExamPlaceReqVo, ExamPlace> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<ExamPlaceVo> list(ExamPlacePageReqVo pageReqVo) {
        return JsonVos.ok(service.list(pageReqVo));
    }
}
