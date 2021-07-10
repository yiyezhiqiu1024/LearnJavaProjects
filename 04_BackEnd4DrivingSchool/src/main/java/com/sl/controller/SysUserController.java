package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.JsonVos;
import com.sl.pojo.po.SysUser;
import com.sl.pojo.result.CodeMsg;
import com.sl.pojo.vo.JsonVo;
import com.sl.pojo.vo.PageJsonVo;
import com.sl.pojo.vo.list.SysUserVo;
import com.sl.pojo.vo.req.page.SysUserPageReqVo;
import com.sl.pojo.vo.req.save. SysUserReqVo;
import com.sl.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping("/sysUsers")
@Api(tags = "用户")
public class SysUserController extends BaseController<SysUser, SysUserReqVo> {

    @Autowired
    private SysUserService service;

    @Override
    protected IService<SysUser> getService() {
        return service;
    }

    @Override
    protected Function<SysUserReqVo, SysUser> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<SysUserVo> list(SysUserPageReqVo reqVo) {
        return JsonVos.ok(service.list(reqVo));
    }

    @PostMapping("/saveUser")
    @ApiOperation("添加或更新【包含角色信息】")
    public JsonVo saveUser(SysUserReqVo reqVo) {
        if (service.saveOrUpdate(reqVo)) {
            return JsonVos.ok(CodeMsg.SAVE_OK);
        } else {
            return JsonVos.raise(CodeMsg.SAVE_ERROR);
        }
    }
}
