package com.example.jianw.flickr_search.View;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jianw.flickr_search.R;
import com.example.jianw.flickr_search.ViewModel.PhotoDetailViewModel;
import com.example.jianw.flickr_search.databinding.PhotoDetailBinding;


/**
 * Created by jian1.w on 11/25/2018.
 */

public class PhotoDetailFragment extends Fragment {
    PhotoDetailViewModel mViewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Bundle bundle = getArguments();
        String uri = bundle.getString("uri");
        String title = bundle.getString("title");
        mViewModel = new PhotoDetailViewModel(uri, title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        PhotoDetailBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.photo_detail,
                container, false);

        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}
