package com.sl.common.enhance;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface Jsonable {
    default String json() throws Exception {
        return new ObjectMapper().writeValueAsString(this);
    }
}
