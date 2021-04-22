package com.sl.bean.base;

import java.util.Date;

public abstract class DateBean extends BaseBean {
    private Date beginDay;

    public Date getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Date beginDay) {
        this.beginDay = beginDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    private Date endDay;

}
