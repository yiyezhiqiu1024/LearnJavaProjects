package com.sl.common.util;

import com.sl.pojo.query.PageQuery;
import com.sl.pojo.result.R;

public class Rs {
    private static final String K_COUNT = "count";

    public static R ok() {
        return new R().setSuccess(true);
    }

    public static R ok(String msg) {
        return ok().setMsg(msg);
    }

    public static R ok(Object data) {
        return ok().setData(data);
    }

    public static R ok(PageQuery query) {
        R r = new R();
        r.put(K_COUNT, query.getTotal());
        return r.setSuccess(true).setData(query.getRecords());
    }

    public static R error(String msg) {
        return new R().setSuccess(false).setMsg(msg);
    }






}
