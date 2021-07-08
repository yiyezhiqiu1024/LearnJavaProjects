package com.sl.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("区域")
public class PlateRegionVo {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("车牌")
    private String plate;

    @ApiModelProperty("父区域的id")
    private Integer parentId;
}


