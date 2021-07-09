package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.SysRole;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.SysRoleVo;
import com.sl.pojo.vo.req.page.SysRolePageReqVo;

public interface SysRoleService extends IService<SysRole> {
    PageVo<SysRoleVo> list(SysRolePageReqVo reqVo);
}
