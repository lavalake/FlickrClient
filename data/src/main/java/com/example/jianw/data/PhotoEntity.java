package com.example.jianw.data;

/**
 * Created by jian1.w on 11/25/2018.
 */

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;


//@JsonAdapter(GsonAdaptersPhotoEntity.class)
public class PhotoEntity {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl_l() {
        return url_l;
    }

    public void setUrl_l(String url_l) {
        this.url_l = url_l;
    }

    public String getUrl_o() {
        return url_o;
    }

    public void setUrl_o(String url_o) {
        this.url_o = url_o;
    }

    public String getUrl_c() {
        return url_c;
    }

    public void setUrl_c(String url_c) {
        this.url_c = url_c;
    }

    public String getUrl_t() {
        return url_t;
    }

    public void setUrl_t(String url_t) {
        this.url_t = url_t;
    }

    String id;
    String secret;
    String server;
    int farm;
    String title;
    String url_l;
    String url_o;
    String url_c;
    String url_t;
    @Override
    public String toString() {
        return "id " + id + " secret: " +secret + " sever: " + server + " farm: " + farm
                + " title: " + title + " url_t: " +url_t;
    }

}
