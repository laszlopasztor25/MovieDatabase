package com.mdb;

import org.joda.time.DateTime;

public class Movie {

    private String title;
    private String stars;
    private int imgId;
    private int vidId;
    private DateTime date;
    private String desc;

    public Movie(String title, String stars, int imgId, int viId,String desc, DateTime date) {
        this.title = title;
        this.stars = stars;
        this.imgId = imgId;
        this.vidId = viId;
        this.desc = desc;
        this.date = date;
    }

    public Movie(String title, String stars, int imgId, int vidId, String desc) {
        this.title = title;
        this.stars = stars;
        this.imgId = imgId;
        this.vidId = vidId;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String description) {
        this.stars = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public int getVidId() {
        return vidId;
    }

    public void setVidId(int vidId) {
        this.vidId = vidId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
