package com.example.jianw.flickr_search.ViewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.jianw.data.PhotoRepositoryFactory;
import com.example.jianw.domain.GetPhotoes;
import com.example.jianw.domain.IPhotoListCallback;
import com.example.jianw.domain.Photo;
import com.example.jianw.domain.PhotoRepository;
import com.example.jianw.flickr_search.BR;
import com.example.jianw.flickr_search.R;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by jian1.w on 11/24/2018.
 */

public class PhotoListViewModel implements IPhotoListCallback{
    public static final String TAG = "PhotoListViewModel";
    public GetPhotoes mGetPhotoes;
    public ObservableList<ThumbNailViewModel> mPhotoes;
    private IRefreshing refreshCallBack;


    public ObservableBoolean refreshing;
    public PhotoListViewModel(IRefreshing refeshCallBack) {
        mGetPhotoes = new GetPhotoes(PhotoRepositoryFactory.getPhotoRepository());
        mGetPhotoes.getPhotoesList(this);
        mPhotoes = new ObservableArrayList<>();
        refreshing = new ObservableBoolean();
        this.refreshCallBack = refeshCallBack;
        refeshCallBack.setRefeshing(true);
    }

    public void setmPhotoes(ObservableList<ThumbNailViewModel> mPhotoes) {
        this.mPhotoes = mPhotoes;
    }

    public ObservableList<ThumbNailViewModel> getmPhotoes() {
        return mPhotoes;
    }


    public ObservableBoolean getRefreshing() {
        return refreshing;
    }

    public void setRefreshing(ObservableBoolean refreshing) {
        Log.e(TAG, "setRefreshing " +refreshing);
        this.refreshing = refreshing;
    }

    public ItemBinding<ThumbNailViewModel> getItemBinding() {
        return itemBinding;
    }

    public ItemBinding<ThumbNailViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.thumb_nail);

    @Override
    public void onResult(List<Photo> result) {
        mPhotoes.clear();
        mPhotoes.addAll(PhotoListViewModelMapper.mapToThumbNailViewModel(result));
        refreshing.set(false);
        refreshCallBack.setRefeshing(false);
        Log.e(TAG, "set refreshing false");
    }

    public void onRefresh() {
        mGetPhotoes.getPhotoesList(this);
    }
}
