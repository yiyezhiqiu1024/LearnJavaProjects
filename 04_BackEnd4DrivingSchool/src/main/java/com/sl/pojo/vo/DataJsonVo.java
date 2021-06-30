package com.sl.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataJsonVo<T> extends JsonVo {
    private T data;

    public DataJsonVo() { }

    public DataJsonVo(T data) {
        this(null, data);
    }

    public DataJsonVo(String msg, T data) {
        super(true, msg);
        this.data = data;
    }

}
