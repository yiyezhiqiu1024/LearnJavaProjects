package com.sl.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("角色")
public class SysRoleVo {
    @ApiModelProperty("主键")
    private Short id;

    @ApiModelProperty("角色名称")
    private String name;

}


