package com.example.jianw.flickr_search.ViewModel;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.common.util.UriUtil;

/**
 * Created by jian1.w on 11/24/2018.
 */

public class ThumbNailViewModel {
    public static final String TAG = "ThumbNailViewModel: ";
    String title;
    Uri link;

    public ThumbNailViewModel(String url, String title) {
        link = UriUtil.parseUriOrNull(url);
        this.title = title;
        Log.d(TAG, "url: " +url);
        Log.d(TAG, "uri: " + link);
    }
    public Uri getLink() {
        Log.e(TAG, "getLink");
        return link;
    }

    public void setLink(Uri link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
