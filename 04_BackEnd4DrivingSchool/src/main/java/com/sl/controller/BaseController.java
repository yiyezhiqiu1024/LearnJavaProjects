package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.exception.CommonException;
import com.sl.common.util.Rs;
import com.sl.pojo.result.R;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Map;

public abstract class BaseController<T> {

    protected abstract IService<T> getService();

    @PostMapping("/remove")
    public Map<String, Object> remove(String id) {
        if (getService().removeByIds(Arrays.asList(id.split(",")))) {
            return Rs.ok("删除成功");
        } else {
            throw new CommonException("删除失败");
        }
    }

    @PostMapping("/save")
    public R save(T t) {
        if (getService().saveOrUpdate(t)) {
            return Rs.ok("保存成功");
        } else {
            throw new CommonException("保存失败");
        }
    }
}
