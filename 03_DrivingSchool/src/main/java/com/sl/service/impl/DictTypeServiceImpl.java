package com.sl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.mapper.DictTypeMapper;
import com.sl.pojo.po.DictType;
import com.sl.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {
    @Autowired
    private DictTypeMapper mapper;
}
