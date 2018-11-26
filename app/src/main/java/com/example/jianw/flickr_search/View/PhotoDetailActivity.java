package com.example.jianw.flickr_search.View;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class PhotoDetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Fragment detailFragment = new PhotoDetailFragment();
            detailFragment.setArguments(this.getIntent().getExtras());
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, detailFragment)
                    .commit();
        }
    }
}
