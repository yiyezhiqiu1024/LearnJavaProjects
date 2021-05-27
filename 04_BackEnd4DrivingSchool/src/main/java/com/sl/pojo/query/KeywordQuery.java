package com.sl.pojo.query;

import lombok.Data;

@Data
public class KeywordQuery<T> extends PageQuery<T> {
    private String keyword;
}
