package com.example.jianw.data;

import android.util.Log;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jian1.w on 11/25/2018.
 */

//@JsonAdapter(GsonAdaptersPhotoesEntity.class)
public class PhotoesEntity {
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerPage() {
        return perpage;
    }

    public void setPerPage(int perPage) {
        this.perpage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PhotoEntity> getPhotoes() {
        return photo;
    }

    public void setPhotoes(List<PhotoEntity> photoes) {
        this.photo = photoes;
    }

    int page;
    int pages;
    int perpage;
    int total;
    List<PhotoEntity> photo;
    @Override
    public String toString(){
        for (PhotoEntity p : photo) {
            Log.d("PhotoesEnity: " , p.toString());
        }
        return String.valueOf(photo.size());
    }
}
