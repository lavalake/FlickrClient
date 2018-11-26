package com.example.jianw.data;

import com.example.jianw.domain.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jian1.w on 11/25/2018.
 */

public class PhotoEntityMapper {
    public static List<Photo> mapToPhoto(List<PhotoEntity> result) {
        List<Photo> photos = new ArrayList<>();
        for (PhotoEntity p : result) {
            photos.add(new Photo(p.getUrl_t(), p.getUrl_o(), p.getTitle()));
        }
        return photos;
    }
}
