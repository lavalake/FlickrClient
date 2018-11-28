package com.example.jianw.domain;

import java.util.UUID;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class Photo {
    String id = UUID.randomUUID().toString();
    String link;
    String title;
    String origin;
    String large;
    String medium;

    public Photo(String url, String orig, String large, String medium, String title) {
        this.link = url;
        this.title = title;
        this.origin = orig;
        this.large = large;
        this.medium = medium;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
