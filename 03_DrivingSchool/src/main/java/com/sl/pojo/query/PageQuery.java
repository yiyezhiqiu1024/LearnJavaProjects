package com.sl.pojo.query;

import lombok.Data;

import java.util.List;

@Data
public class PageQuery<T> {
    private static final long DEFAULT_SIZE = 10;

    private long page;
    private long size;

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

    public long getPage() {
        return Math.max(1, page);
    }

    public long getSize() {
        return (size < 1) ? DEFAULT_SIZE : size;
    }

}
