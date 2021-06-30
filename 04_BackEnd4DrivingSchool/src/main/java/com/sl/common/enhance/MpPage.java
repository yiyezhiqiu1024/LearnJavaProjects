package com.sl.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sl.common.util.Streams;
import com.sl.pojo.vo.PageVo;
import com.sl.pojo.vo.req.page.PageReqVo;

import java.util.List;
import java.util.function.Function;

public class MpPage<T> extends Page<T> {

    private final PageReqVo reqVo;

    public MpPage(PageReqVo reqVo) {
        super(reqVo.getPage(), reqVo.getSize());
        this.reqVo = reqVo;
    }

    public PageVo<T> buildVo() {
        return commonBuildVo(getRecords());
    }

    public <R> PageVo<R> buildVo(Function<T, R> function) {
        return commonBuildVo(Streams.map(getRecords(), function));
    }

    private <N> PageVo<N> commonBuildVo(List<N> records) {
        reqVo.setPage(getCurrent());
        reqVo.setSize(getSize());

        PageVo<N> pageVo = new PageVo<>();
        pageVo.setTotal(getTotal());
        pageVo.setPages(getPages());
        pageVo.setRecords(records);
        return pageVo;
    }
}
