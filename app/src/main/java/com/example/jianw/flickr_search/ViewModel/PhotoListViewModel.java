package com.example.jianw.flickr_search.ViewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

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
    public GetPhotoes mGetPhotoes;
    public ObservableList<ThumbNailViewModel> mPhotoes = new ObservableArrayList<>();

    public PhotoListViewModel() {
        mGetPhotoes = new GetPhotoes(PhotoRepositoryFactory.getPhotoRepository());
        mGetPhotoes.getPhotoesList(this);
    }
    /*
    public void init() {
        for (int i=0; i<100; i++) {
            mPhotoes.add(new ThumbNailViewModel(TEST_URL));
        }
    }
    */
    public void setmPhotoes(ObservableList<ThumbNailViewModel> mPhotoes) {
        this.mPhotoes = mPhotoes;
    }

    public ObservableList<ThumbNailViewModel> getmPhotoes() {
        return mPhotoes;
    }



    public ItemBinding<ThumbNailViewModel> getItemBinding() {
        return itemBinding;
    }

    public ItemBinding<ThumbNailViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.thumb_nail);

    @Override
    public void onResult(List<Photo> result) {
        mPhotoes.clear();
        mPhotoes.addAll(PhotoListViewModelMapper.mapToThumbNailViewModel(result));
    }
}
