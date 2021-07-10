package com.sl.pojo.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户")
public class SysUserVo {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("最后一次登录的时间")
    private Long loginTime;

    @ApiModelProperty("账号的状态，0是正常，1是锁定")
    private Short status;
}


