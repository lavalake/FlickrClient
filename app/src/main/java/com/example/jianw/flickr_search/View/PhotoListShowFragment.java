package com.example.jianw.flickr_search.View;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jianw.data.PhotoRepositoryFactory;
import com.example.jianw.domain.PhotoRepository;
import com.example.jianw.flickr_search.R;
import com.example.jianw.flickr_search.ViewModel.IRefreshing;
import com.example.jianw.flickr_search.databinding.PhotoListBinding;

import com.example.jianw.flickr_search.ViewModel.PhotoListViewModel;

import me.tatarka.bindingcollectionadapter2.LayoutManagers;
//import android.

/**
 * Created by jian1.w on 11/24/2018.
 */

public class PhotoListShowFragment extends Fragment implements IRefreshing{
    private PhotoListViewModel mViewModel;
    private SwipeRefreshLayout mSwip;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);

        mViewModel = new PhotoListViewModel(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PhotoListBinding binding = DataBindingUtil.inflate(inflater,
                                                           R.layout.photo_list,
                                                           container, false);
        mSwip = binding.swipeRefreshLayout;
        binding.photosView.setLayoutManager(LayoutManagers.grid(getActivity().getResources().getInteger(R.integer.galleryColumns)).create(binding.photosView));
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }

    @Override
    public void setRefeshing(boolean state) {
        if (mSwip != null) mSwip.setRefreshing(state);
    }
}
