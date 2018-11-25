package com.example.jianw.flickr_search.ViewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

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

public class PhotoListViewModel {
    public static final String TEST_URL = "https://user-images.githubusercontent.com/35146689/37668564-1c359dae-2c65-11e8-88d4-8923adea4f58.jpg";
    public PhotoListViewModel() {
        init();
    }
    public void init() {
        for (int i=0; i<100; i++) {
            mPhotoes.add(new ThumbNailViewModel(TEST_URL));
        }
    }
    public void setmPhotoes(ObservableList<ThumbNailViewModel> mPhotoes) {
        this.mPhotoes = mPhotoes;
    }

    public ObservableList<ThumbNailViewModel> getmPhotoes() {
        return mPhotoes;
    }

    public ObservableList<ThumbNailViewModel> mPhotoes = new ObservableArrayList<>();

    public ItemBinding<ThumbNailViewModel> getItemBinding() {
        return itemBinding;
    }

    public ItemBinding<ThumbNailViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.thumb_nail);
}
