package com.example.jianw.domain;

import android.net.Uri;

import java.util.List;

/**
 * Created by jian1.w on 11/25/2018.
 */

public interface PhotoRepository {
    public List<Photo> getPohtoList(IPhotoListCallback callback);
    public void savePhotoBitMap(Uri uri, IPhotoSaveCallback callback);
}
