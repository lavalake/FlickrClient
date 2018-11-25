package com.example.jianw.domain;

import java.util.List;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class GetPhotoes {
    PhotoRepository mRepository;
    public GetPhotoes(PhotoRepository repo) {
        mRepository = repo;
    }
    public void getPhotoesList(IPhotoListCallback callback) {
        mRepository.getPohtoList(callback);
    }
}
