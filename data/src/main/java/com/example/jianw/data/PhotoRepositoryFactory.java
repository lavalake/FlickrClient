package com.example.jianw.data;

import com.example.jianw.domain.PhotoRepository;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class PhotoRepositoryFactory {
    static PhotoRepository mRepository;
    public static PhotoRepository getPhotoRepository(){
        if (mRepository == null) {
            synchronized (PhotoRepositoryFactory.class) {
                if (mRepository == null) {
                    OkHttpClient httpClient = new OkHttpClient.Builder().build();
                    FlickrInterface api = new Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(FlickrApiConstants.BASE_URL)
                            .client(httpClient)
                            .build()
                            .create(FlickrInterface.class);
                    mRepository = new PhotoRepositoryImpl(api);
                }
            }
        }
        return mRepository;
    }
}

