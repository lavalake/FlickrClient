package com.example.jianw.flickr_search.ViewModel;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jianw.flickr_search.View.PhotoDetailActivity;
import com.facebook.common.util.UriUtil;

/**
 * Created by jian1.w on 11/24/2018.
 */

public class ThumbNailViewModel {
    public static final String TAG = "ThumbNailViewModel: ";
    String title;
    Uri link;
    String originalLink;

    public ThumbNailViewModel(String thumb, String origin, String title) {
        link = UriUtil.parseUriOrNull(thumb);
        originalLink = origin;
        this.title = title;
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

    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), PhotoDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("uri", originalLink);
        bundle.putString("title", title);
        intent.putExtras(bundle);
        Log.d(TAG, "start photo detail");
        v.getContext().startActivity(intent);

    }

}
