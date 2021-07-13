package com.sl.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.JsonVos;
import com.sl.common.util.Streams;
import com.sl.pojo.po.SysRole;
import com.sl.pojo.vo.DataJsonVo;
import com.sl.pojo.vo.PageJsonVo;
import com.sl.pojo.vo.list.SysRoleVo;
import com.sl.pojo.vo.req.page.SysRolePageReqVo;
import com.sl.pojo.vo.req.save.SysRoleReqVo;
import com.sl.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/sysRoles")
@Api(tags = "角色")
public class SysRoleController extends BaseController<SysRole, SysRoleReqVo> {

    @Autowired
    private SysRoleService service;

    @Override
    protected IService<SysRole> getService() {
        return service;
    }

    @Override
    protected Function<SysRoleReqVo, SysRole> getFunction() {
        return MapStructs.INSTANCE::reqVo2po;
    }

    @GetMapping
    @ApiOperation("分页查询")
    public PageJsonVo<SysRoleVo> list(SysRolePageReqVo reqVo) {
        return JsonVos.ok(service.list(reqVo));
    }

    @GetMapping("/list")
    @ApiOperation("查询所有")
    public DataJsonVo<List<SysRoleVo>> list() {
        return JsonVos.ok(Streams.map(service.list(), MapStructs.INSTANCE::po2vo));
    }

    @GetMapping("/ids")
    @ApiOperation("根据用户id获取角色id")
    public DataJsonVo<List<Short>> ids(Integer userId) {
        return JsonVos.ok(service.listIds(userId));
    }
}
