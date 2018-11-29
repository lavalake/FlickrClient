package com.example.jianw.flickr_search.ViewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.util.Log;

import com.example.jianw.data.PhotoRepositoryFactory;
import com.example.jianw.domain.GetPhotoes;
import com.example.jianw.domain.IPhotoListCallback;
import com.example.jianw.domain.Photo;
import com.example.jianw.flickr_search.BR;
import com.example.jianw.flickr_search.R;
import com.example.jianw.flickr_search.View.BaseFragment;

import java.lang.ref.WeakReference;
import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by jian1.w on 11/24/2018.
 */

public class PhotoListViewModel extends BaseViewModel implements IPhotoListCallback{
    public static final String TAG = "PhotoListViewModel";
    public GetPhotoes mGetPhotoes;
    public ObservableList<ThumbNailViewModel> mPhotoes;
    private WeakReference<IRefreshing> mRefreshCallBack;

    public PhotoListViewModel(BaseFragment fragment) {
        super(fragment);
        mGetPhotoes = new GetPhotoes(PhotoRepositoryFactory.getPhotoRepository());
        mGetPhotoes.getPhotoesList(this);
        mPhotoes = new ObservableArrayList<>();
        mRefreshCallBack = new WeakReference<>((IRefreshing) fragment);
        setRefreshingState(true);
    }

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
        setRefreshingState(false);
        Log.e(TAG, "set refreshing false");
    }

    @Override
    public void onFailure(String error) {
        showToast(error);
        setRefreshingState(false);
    }

    private void setRefreshingState(boolean state) {
        if (mRefreshCallBack.get() != null) mRefreshCallBack.get().setRefeshing(state);
    }

    public void onRefresh() {
        mGetPhotoes.getPhotoesList(this);
    }
}
