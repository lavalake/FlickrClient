package com.example.jianw.domain;

import android.net.Uri;

/**
 * Created by jian1.w on 11/26/2018.
 */

public class SavePhoto{
    PhotoRepository mRepository;
    public SavePhoto(PhotoRepository repo) {
        mRepository = repo;
    }
    public void savePhotoBitMap(Uri uri, IPhotoSaveCallback callback) {
        mRepository.savePhotoBitMap(uri, callback);
    }
}
