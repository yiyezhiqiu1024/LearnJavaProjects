package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpLambdaQueryWrapper;
import com.sl.common.enhance.MpPage;
import com.sl.common.mapStruct.MapStructs;
import com.sl.mapper.SysUserMapper;
import com.sl.pojo.po.SysUser;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.SysUserVo;
import com.sl.pojo.vo.req.page.SysUserPageReqVo;
import com.sl.pojo.vo.req.save.SysUserReqVo;
import com.sl.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

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
        return saveOrUpdate(po);
    }
}
