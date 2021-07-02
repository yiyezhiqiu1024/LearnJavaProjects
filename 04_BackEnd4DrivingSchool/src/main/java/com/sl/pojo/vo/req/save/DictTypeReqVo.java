package com.sl.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictTypeReqVo {
    @ApiModelProperty("id【大于0代表更新，否则代表添加】")
    private Integer id;

    @ApiModelProperty(value = "名称【不能为空】", required = true)
    private String name;

    @ApiModelProperty(value = "值【不能为空】", required = true)
    private String value;

    @ApiModelProperty("简介")
    private String intro;
}


