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
    public ThumbNailViewModel(String url) {
        link = UriUtil.parseUriOrNull(url);
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

    Uri link;

    /*
    @BindingAdapter({"app:imageURI"})
    public static void loadImage(ImageView imageView, Uri link) {
        Glide.with(imageView.getContext())
                .load(link)
                .into(imageView);
    }*/
}
