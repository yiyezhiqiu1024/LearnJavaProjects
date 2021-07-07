package com.sl.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("考场")
public class ExamPlaceVo {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("省份的id")
    private Integer provinceId;

    @ApiModelProperty("城市的id")
    private Integer cityId;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("纬度")
    private Double latitude;

    @ApiModelProperty("经度")
    private Double longitude;
}


