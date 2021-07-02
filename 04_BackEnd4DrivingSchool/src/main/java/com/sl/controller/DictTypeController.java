package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.JsonVos;
import com.sl.common.util.Streams;
import com.sl.pojo.po.DictType;
import com.sl.pojo.vo.DataJsonVo;
import com.sl.pojo.vo.PageJsonVo;
import com.sl.pojo.vo.list.DictTypeVo;
import com.sl.pojo.vo.req.page.DictTypePageReqVo;
import com.sl.pojo.vo.req.save.DictTypeReqVo;
import com.sl.service.DictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/dictTypes")
@Api(tags = "数据字典类型")
public class DictTypeController extends BaseController<DictType, DictTypeReqVo> {

    @Autowired
    private DictTypeService service;

    @Override
    protected IService<DictType> getService() {
        return service;
    }

    @Override
    protected Function<DictTypeReqVo, DictType> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<DictTypeVo> list(DictTypePageReqVo reqVo) {
        return JsonVos.ok(service.list(reqVo));
    }

    @GetMapping("/list")
    @ApiOperation("查询所有")
    public DataJsonVo<List<DictTypeVo>> list() {
         return JsonVos.ok(Streams.map(service.list(), MapStructs.INSTANCE::po2vo));
    }
}
