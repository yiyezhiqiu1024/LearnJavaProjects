package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.util.JsonVos;
import com.sl.pojo.result.CodeMsg;
import com.sl.pojo.vo.JsonVo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.function.Function;

public abstract class BaseController<Po, ReqVo> {

    protected abstract IService<Po> getService();
    protected abstract Function<ReqVo, Po> getFunction();

    @PostMapping("/remove")
    @ApiOperation("删除一条或多条数据")
    public JsonVo remove(@RequestParam String id) {
        if (getService().removeByIds(Arrays.asList(id.split(",")))) {
            return JsonVos.ok(CodeMsg.REMOVE_OK);
        } else {
            return JsonVos.raise(CodeMsg.REMOVE_ERROR);
        }
    }

    @PostMapping("/save")
    @ApiOperation("添加或更新")
    public JsonVo save(ReqVo reqVo) {
        Po po = getFunction().apply(reqVo);
        if (getService().saveOrUpdate(po)) {
            return JsonVos.ok(CodeMsg.SAVE_OK);
        } else {
            return JsonVos.raise(CodeMsg.SAVE_ERROR);
        }
    }
}
