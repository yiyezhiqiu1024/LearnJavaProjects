package com.sl.common.util;

import com.sl.common.exception.CommonException;
import com.sl.pojo.query.PageQuery;
import com.sl.pojo.result.CodeMsg;
import com.sl.pojo.result.R;

public class Rs {
    private static final String K_COUNT = "count";

    public static R ok() {
        return new R(true);
    }

    public static R ok(String msg) {
        return new R(msg);
    }

    public static R ok(Object data) {
        return new R(data);
    }

    public static R ok(PageQuery query) {
        R r = new R(query.getRecords());
        r.put(K_COUNT, query.getTotal());
        return r;
    }

    public static R error(String msg) {
        return new R(false, msg);
    }

    public static R error(Throwable t) {
        if (t instanceof CommonException) {
            CommonException e = (CommonException) t;
            return new R(e.getCode(), e.getMessage());
        } else {
            return error(t.getMessage());
        }
    }

    public static R raise(String msg) throws CommonException {
        throw new CommonException(msg);
    }

    public static R raise(CodeMsg codeMsg) throws CommonException {
        throw new CommonException(codeMsg);
    }

}
