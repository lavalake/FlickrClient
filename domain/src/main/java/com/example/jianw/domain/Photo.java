package com.example.jianw.domain;

import java.util.UUID;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class Photo {
    String id = UUID.randomUUID().toString();
    String link;
    String title;

    public Photo(String url, String title) {
        this.link = url;
        this.title = title;
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
}
