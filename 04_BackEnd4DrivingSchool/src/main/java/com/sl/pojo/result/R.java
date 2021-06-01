package com.sl.pojo.result;

import java.util.HashMap;

/**
 * 返回给用户的JSON对象
 */
public class R extends HashMap<String, Object> {
    public static final String K_CODE = "code";
    public static final String K_MSG = "msg";
    public static final String K_DATA = "data";
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR_DEFAULT = CodeMsg.BAD_REQUEST.getCode();

    public R setCode(int code) {
        put(K_CODE, code);
        return this;
    }

    public R setMsg(String msg) {
        put(K_MSG, msg);
        return this;
    }

    public R setData(Object data) {
        put(K_DATA, data);
        return this;
    }

    public R setSuccess(Boolean success) {
        return success ? setCode(CODE_SUCCESS) : setCode(CODE_ERROR_DEFAULT);
    }

}
