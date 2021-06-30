package com.sl.pojo.vo.req.page;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CityPageReqVo extends KeywordPageReqVo {
    public Integer parentId;
}
