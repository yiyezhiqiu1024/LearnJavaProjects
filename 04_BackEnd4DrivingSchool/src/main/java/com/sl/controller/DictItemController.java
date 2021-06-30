package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.JsonVos;
import com.sl.pojo.po.DictItem;
import com.sl.pojo.vo.PageJsonVo;
import com.sl.pojo.vo.list.DictItemVo;
import com.sl.pojo.vo.req.page.DictItemPageReqVo;
import com.sl.pojo.vo.req.save.DictItemReqVo;
import com.sl.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/dictItems")
public class DictItemController extends BaseController<DictItem, DictItemReqVo> {

    @Autowired
    private DictItemService service;

    @Override
    protected IService<DictItem> getService() {
        return service;
    }

    @Override
    protected Function<DictItemReqVo, DictItem> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }

    @GetMapping
    public PageJsonVo<DictItemVo> list(DictItemPageReqVo pageReqVo) {
        return JsonVos.ok(service.list(pageReqVo));
    }
}
