package com.sl.pojo.vo.req.save;

import lombok.Data;

@Data
public class PlateRegionReqVo {
    // 主键
    private Integer id;
    // 名称
    private String name;
    // 车牌
    private String plate;
    // 拼音
    private String pinyin;
    // 父区域id
    private Integer parentId;
}


