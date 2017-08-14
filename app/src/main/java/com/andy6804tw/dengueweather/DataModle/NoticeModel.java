package com.andy6804tw.dengueweather.DataModle;

/**
 * Created by apple on 2017/8/14.
 */

public class NoticeModel {
    private String level,region,disease,date,context;

    public NoticeModel(String level, String region, String disease, String date, String context) {
        this.level = level;
        this.region = region;
        this.disease = disease;
        this.date = date;
        this.context = context;
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

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
