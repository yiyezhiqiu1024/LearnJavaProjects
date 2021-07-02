package com.sl.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageJsonVo<T> extends DataJsonVo<List<T>> {
    @ApiModelProperty("总数")
    private long count;

    @ApiModelProperty("总页数")
    private long pages;
}
