package com.example.jianw.flickr_search.ViewModel;

import com.example.jianw.flickr_search.View.BaseFragment;

import java.lang.ref.WeakReference;

/**
 * Created by jian1.w on 11/28/18.
 */

public class BaseViewModel {
    private WeakReference<IShowToast> mToastCallBack;
    public BaseViewModel(BaseFragment fragment) {
        mToastCallBack = new WeakReference<>((IShowToast) fragment);
    }

    protected void showToast(String message) {
        if (mToastCallBack.get() != null) mToastCallBack.get().showToast(message);
    }

}
