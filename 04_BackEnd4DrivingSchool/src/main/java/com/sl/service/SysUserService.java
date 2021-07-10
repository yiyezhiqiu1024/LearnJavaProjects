package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.SysUser;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.SysUserVo;
import com.sl.pojo.vo.req.page.SysUserPageReqVo;
import com.sl.pojo.vo.req.save.SysUserReqVo;

public interface SysUserService extends IService<SysUser> {
    PageVo<SysUserVo> list(SysUserPageReqVo reqVo);
    boolean saveOrUpdate(SysUserReqVo reqVo);
}
