package com.example.jianw.data;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jian1.w on 11/25/2018.
 */

//@JsonAdapter(GsonAdaptersPhotoesResponseEntity.class)
public class PhotoesResponseEntity {
     @SerializedName("photos")
     public PhotoesEntity photes;
     public PhotoesEntity getPhotes() {
          return photes;
     }

     public void setPhotes(PhotoesEntity photes) {
          this.photes = photes;
     }
/*
     @Override
     public String toString() {
         return photes.toString();
     }
     */
}
