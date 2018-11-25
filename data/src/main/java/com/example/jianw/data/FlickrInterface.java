package com.example.jianw.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jian1.w on 11/25/2018.
 */

public interface FlickrInterface {
    @GET("services/rest/?method=flickr.photos.search&nojsoncallback=1&format=json")
    public Call<PhotoesResponseEntity> search (@Query("api_key") String apiKey,
                                               @Query("text") String text,
                                               @Query("extras") String extras);
}
