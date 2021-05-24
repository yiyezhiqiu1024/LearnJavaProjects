package com.sl.service.impl;

import com.sl.mapper.DictTypeMapper;
import com.sl.pojo.po.DictType;
import com.sl.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DictTypeServiceImpl implements DictTypeService {
    @Autowired
    private DictTypeMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<DictType> list() {
        return mapper.list();
    }
}
