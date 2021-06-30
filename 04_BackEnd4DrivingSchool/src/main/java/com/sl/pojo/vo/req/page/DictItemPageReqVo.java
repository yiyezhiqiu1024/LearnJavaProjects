package com.sl.pojo.vo.req.page;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DictItemPageReqVo extends KeywordPageReqVo {
    private Integer typeId;
}
