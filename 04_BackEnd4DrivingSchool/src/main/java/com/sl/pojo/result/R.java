package com.sl.pojo.result;

import com.sl.common.enhance.Jsonable;

import java.util.HashMap;

/**
 * 返回给用户的JSON对象
 */
public class R extends HashMap<String, Object> implements Jsonable {
    public static final String K_CODE = "code";
    public static final String K_MSG = "msg";
    public static final String K_DATA = "data";
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR_DEFAULT = CodeMsg.BAD_REQUEST.getCode();

    public R() {
        this(true);
    }

    public R(boolean success) {
        this(success, null);
    }

    public R(boolean success, String msg) {
        this(success ? CODE_SUCCESS : CODE_ERROR_DEFAULT, msg);
    }

    public R(CodeMsg codeMsg) {
        this(codeMsg.getCode(), codeMsg.getMsg());
    }

    public R(int code, String msg) {
        put(K_CODE, code);
        put(K_MSG, msg);
    }

    public R(String msg, Object data) {
        this(data);
        put(K_MSG, msg);
    }

    public R(Object data) {
        put(K_CODE, CODE_SUCCESS);
        put(K_DATA, data);
    }
}
