package com.example.jianw.flickr_search.ViewModel;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.jianw.data.FrescoUtil;
import com.example.jianw.data.PhotoRepositoryFactory;
import com.example.jianw.domain.IPhotoSaveCallback;
import com.example.jianw.domain.SavePhoto;
import com.example.jianw.flickr_search.CustomApplication;
import com.example.jianw.flickr_search.View.BaseFragment;
import com.facebook.common.util.UriUtil;

import java.lang.ref.WeakReference;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class PhotoDetailViewModel extends BaseViewModel implements IPhotoSaveCallback{
    public static final String TAG = "PhotoDetailViewModel";
    Uri uri;
    String title;
    SavePhoto mSavePhoto;
    public PhotoDetailViewModel(String uri, String title, BaseFragment fragment) {
        super(fragment);
        this.uri = UriUtil.parseUriOrNull(uri);
        this.title = title;
        mSavePhoto = new SavePhoto(PhotoRepositoryFactory.getPhotoRepository());
    }
    public Uri getUri() {
        Log.d(TAG, "getUri: " +uri);
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getTitle() {
        Log.d(TAG, "getTitle: " +title);
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void onClick(View v) {
        Log.e(TAG, "clicked uri " + uri);
        mSavePhoto.savePhotoBitMap(uri, this);
    }

    @Override
    public void onResult(Uri uri) {
        String toastMessage;
        CustomApplication.getAppContext().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
        toastMessage = "Saved Photo to Album";

        showToast(toastMessage);
    }

    @Override
    public void onFailure(String error){
        showToast(error);
    }
}
