package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpPage;
import com.sl.common.enhance.MpQueryWrapper;
import com.sl.mapper.DictTypeMapper;
import com.sl.pojo.po.DictType;
import com.sl.pojo.query.DictTypeQuery;
import com.sl.service.DictTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Override
    @Transactional(readOnly = true)
    public void list(DictTypeQuery query) {
        // 查询条件
        MpQueryWrapper<DictType> queryWrapper = new MpQueryWrapper<>();
        // 关键字
        queryWrapper.like(query.getKeyword(), DictType::getName, DictType::getValue, DictType::getIntro);
        // 按照id降序
        queryWrapper.orderByDesc(DictType::getId);
        // 分页查询
        baseMapper.selectPage(new MpPage<>(query), queryWrapper).updateQuery();
    }
}
