package com.sl.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DictItemQuery extends KeywordQuery {
    private Integer typeId;
}
