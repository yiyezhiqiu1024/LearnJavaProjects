package com.sl.pojo.po;

import java.math.BigDecimal;
import java.util.Date;

public class ExamPlaceCourse {
    private Integer id;

    private Date createTime;

    private String name;

    private BigDecimal price;

    private Byte type;

    private String intro;

    private String video;

    private String cover;

    private Short placeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Short getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Short placeId) {
        this.placeId = placeId;
    }
}