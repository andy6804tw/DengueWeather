package com.andy6804tw.dengueweather.DataModle;

/**
 * Created by apple on 2017/8/14.
 */

public class NoticeModel {
    private String level,region,date,detail,url;

    public NoticeModel(String level, String region, String date, String detail,String url) {
        this.level = level;
        this.region = region;
        this.date = date;
        this.detail = detail;
        this.url = url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String context) {
        this.detail = detail;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
