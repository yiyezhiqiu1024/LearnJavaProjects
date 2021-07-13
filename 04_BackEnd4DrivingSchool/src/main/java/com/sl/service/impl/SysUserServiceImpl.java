package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpLambdaQueryWrapper;
import com.sl.common.enhance.MpPage;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.Constants;
import com.sl.common.util.JsonVos;
import com.sl.common.util.Strings;
import com.sl.mapper.SysUserMapper;
import com.sl.pojo.po.SysUser;
import com.sl.pojo.po.SysUserRole;
import com.sl.pojo.result.CodeMsg;
import com.sl.pojo.vo.LoginVo;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.SysUserVo;
import com.sl.pojo.vo.req.LoginReqVo;
import com.sl.pojo.vo.req.page.SysUserPageReqVo;
import com.sl.pojo.vo.req.save.SysUserReqVo;
import com.sl.service.SysUserRoleService;
import com.sl.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserRoleService userRoleService;

    @Override
    public LoginVo login(LoginReqVo reqVo) {
        // 根据用户名查询用户
        MpLambdaQueryWrapper<SysUser> wrapper = new MpLambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, reqVo.getUsername());
        SysUser po = baseMapper.selectOne(wrapper);

        // 用户名不存在
        if (po == null) {
            return JsonVos.raise(CodeMsg.WRONG_USERNAME);
        }

        // 密码不正确
        if (!po.getPassword().equals(reqVo.getPassword())) {
            return JsonVos.raise(CodeMsg.WRONG_PASSWORD);
        }

        // 账号锁定
        if (po.getStatus() == Constants.SysUserStatus.LOCKED) {
            return JsonVos.raise(CodeMsg.USER_LOCKED);
        }

        // 更新登录时间
        po.setLoginTime(new Date());
        baseMapper.updateById(po);

        return MapStructs.INSTANCE.po2loginVo(po);
    }

    @Override
    @Transactional(readOnly = true)
    public PageVo<SysUserVo> list(SysUserPageReqVo reqVo) {
        // 查询条件
        MpLambdaQueryWrapper<SysUser> queryWrapper = new MpLambdaQueryWrapper<>();
        // 关键字
        queryWrapper.like(reqVo.getKeyword(), SysUser::getNickname, SysUser::getUsername);
        // 按照id降序
        queryWrapper.orderByDesc(SysUser::getId);
        // 分页查询
        return baseMapper.selectPage(new MpPage<>(reqVo), queryWrapper).buildVo(MapStructs.INSTANCE::po2vo);
    }

    @Override
    public boolean saveOrUpdate(SysUserReqVo reqVo) {
        // 转成PO
        SysUser po = MapStructs.INSTANCE.reqVo2po(reqVo);

        // 保存用户信息
        if (!saveOrUpdate(po)) return false;

        // 删除当前用户的所有角色
        userRoleService.removeByUserId(reqVo.getId());

        // 保存角色信息
        String roleIdsStr = reqVo.getRoleIds();
        if (Strings.isEmpty(roleIdsStr)) return true;

        String[] roleIds = roleIdsStr.split(",");
        List<SysUserRole> userRoles = new ArrayList<>();
        Integer userId = po.getId();
        for (String roleId : roleIds) {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(Short.parseShort(roleId));
            userRoles.add(userRole);
        }
        return userRoleService.saveBatch(userRoles);
    }
}
