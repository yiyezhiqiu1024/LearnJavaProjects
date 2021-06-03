package com.sl.pojo.po;

import com.sl.common.foreign.anno.ForeignField;
import lombok.Data;

@Data
public class PlateRegion {
    // 主键
    private Integer id;
    // 名称
    private String name;
    // 车牌
    private String plate;
    // 拼音
    private String pinyin;
    @ForeignField(PlateRegion.class)
    private Integer parentId;
}


