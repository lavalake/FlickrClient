package com.example.jianw.domain;

import android.net.Uri;

/**
 * Created by jian1.w on 11/26/2018.
 */

public interface IPhotoSaveCallback {
    public void onResult(Uri uri);
    public void onFailure(String error);
}
