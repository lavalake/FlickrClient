package com.example.jianw.flickr_search.ViewModel;

import android.net.Uri;
import android.util.Log;

import com.facebook.common.util.UriUtil;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class PhotoDetailViewModel {
    public static final String TAG = "PhotoDetailViewModel";
    Uri uri;
    String title;
    public PhotoDetailViewModel(String uri, String title) {
        this.uri = UriUtil.parseUriOrNull(uri);
        this.title = title;
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
}
