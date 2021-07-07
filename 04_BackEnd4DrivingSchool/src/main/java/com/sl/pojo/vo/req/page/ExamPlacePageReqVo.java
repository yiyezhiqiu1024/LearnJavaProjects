package com.sl.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExamPlacePageReqVo extends KeywordPageReqVo {
    @ApiModelProperty("省份的id")
    private Integer provinceId;
    @ApiModelProperty("城市的id")
    private Integer cityId;
}



