package com.sl.common.util;

import com.sl.common.exception.CommonException;
import com.sl.pojo.result.CodeMsg;
import com.sl.pojo.vo.DataJsonVo;
import com.sl.pojo.vo.JsonVo;
import com.sl.pojo.vo.PageJsonVo;
import com.sl.pojo.vo.PageVo;

public class JsonVos {
    public static JsonVo ok() {
        return new JsonVo();
    }

    public static JsonVo ok(CodeMsg msg) {
        return new JsonVo(msg);
    }

    public static JsonVo ok(String msg) {
        return new JsonVo(true, msg);
    }

    public static <T> DataJsonVo<T> ok(T data) {
        return new DataJsonVo<>(data);
    }

    public static <T> PageJsonVo<T> ok(PageVo<T> pageVo) {
        PageJsonVo<T> pageJsonVo = new PageJsonVo<>();
        pageJsonVo.setCount(pageVo.getTotal());
        pageJsonVo.setPages(pageVo.getPages());
        pageJsonVo.setData(pageVo.getRecords());
        return pageJsonVo;
    }

    public static JsonVo error() {
        return new JsonVo(false);
    }

    public static JsonVo error(CodeMsg msg) {
        return new JsonVo(msg);
    }

    public static JsonVo error(int code, String msg) {
        return new JsonVo(code, msg);
    }

    public static JsonVo error(String msg) {
        return new JsonVo(false, msg);
    }

    public static <T> T raise(String msg) throws CommonException {
        throw new CommonException(msg);
    }

    public static <T> T raise(CodeMsg codeMsg) throws CommonException {
        throw new CommonException(codeMsg);
    }

}
