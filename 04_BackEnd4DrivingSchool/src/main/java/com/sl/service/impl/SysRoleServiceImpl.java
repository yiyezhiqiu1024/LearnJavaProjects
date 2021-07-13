package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpLambdaQueryWrapper;
import com.sl.common.enhance.MpPage;
import com.sl.common.mapStruct.MapStructs;
import com.sl.common.util.Streams;
import com.sl.mapper.SysRoleMapper;
import com.sl.mapper.SysUserRoleMapper;
import com.sl.pojo.po.SysRole;
import com.sl.pojo.po.SysUserRole;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.SysRoleVo;
import com.sl.pojo.vo.req.page.SysRolePageReqVo;
import com.sl.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Override
    @Transactional(readOnly = true)
    public PageVo<SysRoleVo> list(SysRolePageReqVo reqVo) {
        // 查询条件
        MpLambdaQueryWrapper<SysRole> queryWrapper = new MpLambdaQueryWrapper<>();
        // 关键字
        queryWrapper.like(reqVo.getKeyword(), SysRole::getName);
        // 按照id降序
        queryWrapper.orderByDesc(SysRole::getId);
        // 分页查询
        return baseMapper.selectPage(new MpPage<>(reqVo), queryWrapper).buildVo(MapStructs.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Short> listIds(Integer userId) {
        if (userId == null || userId <= 0) return null;

        MpLambdaQueryWrapper<SysUserRole> queryWrapper = new MpLambdaQueryWrapper<>();
        queryWrapper.select(SysUserRole::getRoleId);
        queryWrapper.eq(SysUserRole::getUserId, userId);

        List<Object> ids = userRoleMapper.selectObjs(queryWrapper);
        return Streams.map(ids, (id) -> ((Integer) id).shortValue());
    }
}
