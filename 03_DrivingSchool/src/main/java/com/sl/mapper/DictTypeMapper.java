package com.sl.mapper;

import com.sl.pojo.po.DictType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DictTypeMapper {
    @Select("SELECT id, name, value, intro FROM dict_type")
    List<DictType> list();
}
