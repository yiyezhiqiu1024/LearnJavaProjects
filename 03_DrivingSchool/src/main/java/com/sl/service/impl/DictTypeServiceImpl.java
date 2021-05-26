package com.sl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.mapper.DictTypeMapper;
import com.sl.pojo.po.DictType;
import com.sl.pojo.query.DictTypeQuery;
import com.sl.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {
    @Autowired
    private DictTypeMapper mapper;

    @Override
    public void list(DictTypeQuery query) {
        // 查询条件
        LambdaQueryWrapper<DictType> queryWrapper = new LambdaQueryWrapper<>();

        // 关键字
        String keyword = query.getKeyword();
        if (!StringUtils.isEmpty(keyword)) {
            queryWrapper.like(DictType::getName, keyword).or()
                    .like(DictType::getValue, keyword).or()
                    .like(DictType::getIntro, keyword);
        }

        // 分页对象
        Page<DictType> page = new Page<>(query.getPage(), query.getSize());
        // 查询
        mapper.selectPage(page, queryWrapper);
        // 填充query
        query.setRecords(page.getRecords());
        query.setTotal(page.getTotal());
        query.setPages(page.getPages());
    }
}
