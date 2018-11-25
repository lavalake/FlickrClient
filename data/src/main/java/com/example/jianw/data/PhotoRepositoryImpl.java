package com.example.jianw.data;

import android.util.Log;

import com.example.jianw.domain.IPhotoListCallback;
import com.example.jianw.domain.Photo;
import com.example.jianw.domain.PhotoRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class PhotoRepositoryImpl implements PhotoRepository {
    public static final String TEST_URL = "https://user-images.githubusercontent.com/35146689/37668564-1c359dae-2c65-11e8-88d4-8923adea4f58.jpg";
    FlickrInterface api;
    public PhotoRepositoryImpl(FlickrInterface api) {
        this.api = api;
    }
    @Override
    public List<Photo> getPohtoList(final IPhotoListCallback callback) {
        List<Photo> photoes = new ArrayList<>();
        Call<PhotoesResponseEntity> call = api.search(FlickrApiConstants.API_KEY, "shark", FlickrApiConstants.EXTRA_URLS);
        call.enqueue(new Callback<PhotoesResponseEntity>() {
            @Override
            public void onResponse(Call<PhotoesResponseEntity> call, Response<PhotoesResponseEntity> response) {
                PhotoesResponseEntity res = response.body();
                Log.d("CALLBACK","get response!!!!!" + res);
                callback.onResult(PhotoEntityMapper.mapToPhoto(res.getPhotes().getPhotoes()));
            }
            @Override
            public void onFailure (Call<PhotoesResponseEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return photoes;
    }
}
