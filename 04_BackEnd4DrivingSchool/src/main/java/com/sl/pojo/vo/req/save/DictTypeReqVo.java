package com.sl.pojo.vo.req.save;

import lombok.Data;

@Data
public class DictTypeReqVo {
    // 主键
    private Integer id;
    // 名称
    private String name;
    // 值
    private String value;
    // 简介
    private String intro;
}


