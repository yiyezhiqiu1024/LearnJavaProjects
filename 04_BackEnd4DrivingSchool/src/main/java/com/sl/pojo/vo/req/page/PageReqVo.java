package com.sl.pojo.vo.req.page;

import lombok.Data;

@Data
public class PageReqVo {
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
