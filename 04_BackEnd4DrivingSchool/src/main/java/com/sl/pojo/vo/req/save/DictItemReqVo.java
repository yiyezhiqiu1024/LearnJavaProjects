package com.sl.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DictItemReqVo {

    @ApiModelProperty("id【大于0代表更新，否则代表添加】")
    private Integer id;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称【不能为空】", required = true)
    private String name;

    @NotBlank(message = "值不能为空")
    @ApiModelProperty(value = "值【不能为空】", required = true)
    private String value;

    @Min(value = 0, message = "排列顺序不能是负数")
    @ApiModelProperty("排列顺序，默认0【值越大，就排在越前面】")
    private Integer sn;


    @ApiModelProperty("是否禁用【0代表不禁用（启用），1代表禁用】")
    private Short disabled;

    @NotNull
    @ApiModelProperty(value = "数据字典类型的id", required = true)
    private Integer typeId;
}


