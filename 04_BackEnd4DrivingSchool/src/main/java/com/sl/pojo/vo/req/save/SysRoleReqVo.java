package com.sl.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysRoleReqVo {
    @ApiModelProperty("主键")
    private Short id;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称【不能为空】", required = true)
    private String name;

}


