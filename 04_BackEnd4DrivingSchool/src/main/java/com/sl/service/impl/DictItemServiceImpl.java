package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.common.enhance.MpPage;
import com.sl.common.enhance.MpQueryWrapper;
import com.sl.mapper.DictItemMapper;
import com.sl.pojo.po.DictItem;
import com.sl.pojo.query.DictItemQuery;
import com.sl.service.DictItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {

    @Override
    public void list(DictItemQuery query) {
        // 查询条件
        MpQueryWrapper<DictItem> queryWrapper = new MpQueryWrapper<>();
        // 关键字
        queryWrapper.like(query.getKeyword(), DictItem::getName, DictItem::getValue);
        // 按照id降序
        queryWrapper.orderByDesc(DictItem::getId);
        // 分页查询
        baseMapper.selectPage(new MpPage<>(query), queryWrapper).updateQuery();
    }
}
