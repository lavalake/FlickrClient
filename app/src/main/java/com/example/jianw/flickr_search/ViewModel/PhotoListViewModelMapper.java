package com.example.jianw.flickr_search.ViewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.example.jianw.domain.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class PhotoListViewModelMapper {
    public static ObservableList<ThumbNailViewModel> mapToThumbNailViewModel(List<Photo> photoes){
        ObservableList<ThumbNailViewModel> result = new ObservableArrayList<>();
        for (Photo p : photoes) {
            result.add(new ThumbNailViewModel(p.getLink(), p.getOrigin(), p.getLarge(), p.getTitle()));
        }
        return result;
    }
}
