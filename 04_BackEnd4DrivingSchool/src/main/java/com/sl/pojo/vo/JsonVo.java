package com.sl.pojo.vo;

import com.sl.pojo.result.CodeMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("返回结果")
@Data
public class JsonVo {
    public static final int CODE_OK = CodeMsg.OPERATE_OK.getCode();
    public static final int CODE_ERROR = CodeMsg.BAD_REQUEST.getCode();

    @ApiModelProperty("代码【0代表成功，其他代表失败】")
    private Integer code;

    @ApiModelProperty("消息描述")
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
