package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.util.JsonVos;
import com.sl.pojo.result.CodeMsg;
import com.sl.pojo.vo.JsonVo;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.function.Function;

public abstract class BaseController<Po, ReqVo> {

    protected abstract IService<Po> getService();
    protected abstract Function<ReqVo, Po> getFunction();

    @PostMapping("/remove")
    public JsonVo remove(String id) {
        if (getService().removeByIds(Arrays.asList(id.split(",")))) {
            return JsonVos.ok(CodeMsg.REMOVE_OK);
        } else {
            return JsonVos.raise(CodeMsg.REMOVE_ERROR);
        }
    }

    @PostMapping("/save")
    public JsonVo save(ReqVo reqVo) {
        Po po = getFunction().apply(reqVo);
        if (getService().saveOrUpdate(po)) {
            return JsonVos.ok(CodeMsg.SAVE_OK);
        } else {
            return JsonVos.raise(CodeMsg.SAVE_ERROR);
        }
    }
}
