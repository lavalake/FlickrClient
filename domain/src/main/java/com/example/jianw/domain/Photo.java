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

    public Photo(String url, String orig, String title) {
        this.link = url;
        this.title = title;
        this.origin = orig;
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

}
