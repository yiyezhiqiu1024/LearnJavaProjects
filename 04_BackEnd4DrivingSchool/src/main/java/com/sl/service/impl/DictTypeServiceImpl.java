package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpPage;
import com.sl.common.enhance.MpLambdaQueryWrapper;
import com.sl.common.mapStruct.MapStructs;
import com.sl.mapper.DictTypeMapper;
import com.sl.pojo.po.DictType;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.list.DictTypeVo;
import com.sl.pojo.vo.req.page.DictTypePageReqVo;
import com.sl.service.DictTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<DictTypeVo> list(DictTypePageReqVo reqVo) {
        // 查询条件
        MpLambdaQueryWrapper<DictType> queryWrapper = new MpLambdaQueryWrapper<>();
        // 关键字
        queryWrapper.like(reqVo.getKeyword(), DictType::getName, DictType::getValue, DictType::getIntro);
        // 按照id降序
        queryWrapper.orderByDesc(DictType::getId);
        // 分页查询
        return baseMapper.selectPage(new MpPage<>(reqVo), queryWrapper).buildVo(MapStructs.INSTANCE::po2vo);
    }
}
