package com.sl.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ExamPlaceCoursePageReqVo extends KeywordPageReqVo {
    @ApiModelProperty("课程类型【0是课程合集，2是科目2，3是科目3】")
    private Short type;

    @ApiModelProperty("省份的id")
    private Integer provinceId;

    @ApiModelProperty("城市的id")
    private Integer cityId;

    @ApiModelProperty("考场的id")
    private Integer placeId;
}



