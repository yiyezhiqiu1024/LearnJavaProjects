package com.sl.pojo.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVo<T> {
    /**
     * 总记录数
     */
    private long total;
    /**
     * 总页数
     */
    private long pages;

    /**
     * 记录数据
     */
    private List<T> records;
}
