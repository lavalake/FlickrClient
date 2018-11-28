package com.example.jianw.domain;

import java.util.List;

/**
 * Created by jian1.w on 11/25/2018.
 */

public interface IPhotoListCallback {
    public void onResult(List<Photo> result);
    public void onFailure(String error);
}
