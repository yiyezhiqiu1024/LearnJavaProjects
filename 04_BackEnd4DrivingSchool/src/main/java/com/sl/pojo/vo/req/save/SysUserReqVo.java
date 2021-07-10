package com.sl.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysUserReqVo {
    @ApiModelProperty("主键")
    private Integer id;

    @NotBlank(message = "昵称不能为空")
    @ApiModelProperty(value = "昵称【不能为空】", required = true)
    private String nickname;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名【不能为空】", required = true)
    private String username;

    @ApiModelProperty("密码【如果为空，说明不修改密码】")
    private String password;

    @ApiModelProperty("账号的状态【0是正常，1是锁定，默认0】")
    private Short status;

}


