package com.sl.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseBean {
    private Integer id;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonIgnore
    public String getJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        return mapper.writeValueAsString(this).replace("\"", "'");
//        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//        String beginDayString = fmt.format(beginDay);
//        String endDayString = fmt.format(endDay);
//        return "{name:'" + name + "', intro:'"
//                + intro + "', beginDay:'" + beginDayString
//                + "', endDay:'" + endDayString + "', type:" + type + "}";
    }
}
