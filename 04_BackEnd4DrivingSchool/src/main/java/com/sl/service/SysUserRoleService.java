package com.sl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sl.pojo.po.SysUserRole;

public interface SysUserRoleService extends IService<SysUserRole> {
    boolean removeByUserId(Integer userId);
}
