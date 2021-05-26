package com.sl.pojo.query;

import lombok.Data;

@Data
public class PageQuery {
    private static final long DEFAULT_SIZE = 10;

    private long page;
    private long size;

    public long getPage() {
        return Math.max(1, page);
    }

    public long getSize() {
        return (size < 1) ? DEFAULT_SIZE : size;
    }

}
