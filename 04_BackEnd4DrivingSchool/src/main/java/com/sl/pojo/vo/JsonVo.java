package com.sl.pojo.vo;

import com.sl.pojo.result.CodeMsg;
import lombok.Data;


/**
 * 返回给用户的JSON对象
 */
@Data
public class JsonVo {
    public static final int CODE_OK = CodeMsg.OPERATE_OK.getCode();
    public static final int CODE_ERROR = CodeMsg.BAD_REQUEST.getCode();

    private Integer code;

    private String msg;

    public JsonVo() {
        this(true);
    }

    public JsonVo(boolean ok) {
        this(true, null);
    }

    public JsonVo(boolean ok, String msg) {
        this(ok ? CODE_OK : CODE_ERROR, msg);
    }

    public JsonVo(CodeMsg codeMsg) {
        this(codeMsg.getCode(), codeMsg.getMsg());
    }

    public JsonVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
