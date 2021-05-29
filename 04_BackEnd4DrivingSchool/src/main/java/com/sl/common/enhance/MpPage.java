package com.sl.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sl.pojo.query.PageQuery;

public class MpPage<T> extends Page<T> {
    public MpPage(PageQuery query) {
        super(query.getPage(), query.getSize());
    }

    public void updateQuery(PageQuery query) {
        query.setTotal(getTotal());
        query.setPages(getPages());
        query.setRecords(getRecords());
        query.setPage(getCurrent());
        query.setSize(getSize());
    }

}
