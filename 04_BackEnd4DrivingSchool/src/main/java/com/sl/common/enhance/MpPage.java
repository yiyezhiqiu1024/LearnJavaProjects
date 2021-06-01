package com.sl.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sl.pojo.query.PageQuery;

public class MpPage<T> extends Page<T> {

    private PageQuery query;

    public MpPage(PageQuery query) {
        super(query.getPage(), query.getSize());
        this.query = query;
    }

    public void updateQuery() {
        query.setTotal(getTotal());
        query.setPages(getPages());
        query.setRecords(getRecords());
        query.setPage(getCurrent());
        query.setSize(getSize());
    }

}
