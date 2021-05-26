package com.sl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.mapper.DictItemMapper;
import com.sl.pojo.po.DictItem;
import com.sl.pojo.query.DictItemQuery;
import com.sl.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {
    @Autowired
    private DictItemMapper mapper;

    @Override
    public void list(DictItemQuery query) {
        // 查询条件
        LambdaQueryWrapper<DictItem> queryWrapper = new LambdaQueryWrapper<>();

        // 关键字
        String keyword = query.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
            queryWrapper.like(DictItem::getName, keyword).or()
                    .like(DictItem::getValue, keyword);
        }

        // 分页对象
        Page<DictItem> page = new Page<>(query.getPage(), query.getSize());
        // 查询
        mapper.selectPage(page, queryWrapper);
        // 填充query
        query.setRecords(page.getRecords());
        query.setTotal(page.getTotal());
        query.setPages(page.getPages());
    }
}
