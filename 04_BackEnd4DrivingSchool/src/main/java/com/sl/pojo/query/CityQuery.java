package com.sl.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CityQuery extends KeywordQuery {
    public Integer parentId;
}
