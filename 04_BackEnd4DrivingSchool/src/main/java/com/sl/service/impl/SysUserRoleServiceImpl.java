package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpLambdaQueryWrapper;
import com.sl.mapper.SysUserRoleMapper;
import com.sl.pojo.po.SysUserRole;
import com.sl.service.SysUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Override
    public boolean removeByUserId(Integer userId) {
        if (userId == null || userId <= 0) return false;
        MpLambdaQueryWrapper<SysUserRole> queryWrapper = new MpLambdaQueryWrapper<>();
        queryWrapper.eq(SysUserRole::getUserId, userId);
        return baseMapper.delete(queryWrapper) > 0;
    }
}
