package com.sl.pojo.vo.req.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictItemReqVo {

    @ApiModelProperty("id【大于0代表更新，否则代表添加】")
    private Integer id;

    @ApiModelProperty(value = "名称【不能为空】", required = true)
    private String name;

    @ApiModelProperty(value = "值【不能为空】", required = true)
    private String value;

    @ApiModelProperty("排列顺序，默认0【值越大，就排在越前面】")
    private Integer sn;

    @ApiModelProperty("是否禁用【0代表不禁用（启用），1代表禁用】")
    private Short disabled;

    @ApiModelProperty(value = "数据字典类型的id", required = true)
    private Integer typeId;
}


