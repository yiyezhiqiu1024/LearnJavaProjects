package com.sl.pojo.vo.req.save;

import lombok.Data;

@Data
public class DictItemReqVo {
    // 主键
    private Integer id;
    // 名称
    private String name;
    // 值
    private String value;
    // 排列顺序，默认0。值越大，就排在越前面
    private Integer sn;
    // 是否禁用 0代表不禁用（启用），1代表禁用
    private Short disabled;
    // 所属的类型
    private Integer typeId;
}


