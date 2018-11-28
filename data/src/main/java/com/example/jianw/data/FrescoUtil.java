package com.example.jianw.data;

/**
 * Created by jian1.w on 11/26/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.example.jianw.domain.IPhotoSaveCallback;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FrescoUtil {

    private static final String TAG = "FrescoUtil";
    private static final String SUFFIX = ".jpg";
    public static final String IMAGE_PIC_CACHE_DIR = Environment.getExternalStorageDirectory().getPath()+"/Android/";

    public static void savePicture(Uri picUri, IPhotoSaveCallback callback) {

        File picDir = new File(IMAGE_PIC_CACHE_DIR);

        if (!picDir.exists()) {
            picDir.mkdir();
        }
        String fileName = String.valueOf(picUri.hashCode()) + SUFFIX;
        File file = new File(picDir, fileName);
        if (file.exists()) {
            callback.onResult(Uri.fromFile(file), true);
            return;
        }
        downLoadImage(picUri,fileName, callback);
        return;

    }

    public static File getCachedImageOnDisk(CacheKey cacheKey) {
        File localFile = null;
        if (cacheKey != null) {
            if (ImagePipelineFactory.getInstance().getMainDiskStorageCache().hasKey(cacheKey)) {
                BinaryResource resource = ImagePipelineFactory.getInstance().getMainDiskStorageCache().getResource(cacheKey);
                localFile = ((FileBinaryResource) resource).getFile();
            } else if (ImagePipelineFactory.getInstance().getSmallImageDiskStorageCache().hasKey(cacheKey)) {
                BinaryResource resource = ImagePipelineFactory.getInstance().getSmallImageDiskStorageCache().getResource(cacheKey);
                localFile = ((FileBinaryResource) resource).getFile();
            }
        }
        return localFile;
    }

    public static void downLoadImage(Uri uri, final String filename, final IPhotoSaveCallback callback) {
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        DataSource<CloseableReference<CloseableImage>>
                dataSource = imagePipeline.fetchDecodedImage(imageRequest, null);
        dataSource.subscribe(new BaseBitmapDataSubscriber() {
            @Override
            public void onNewResultImpl(Bitmap bitmap) {
                if (bitmap == null) {
                    Log.e(TAG,"fail to download pic");
                }
                File appDir = new File(IMAGE_PIC_CACHE_DIR);
                if (!appDir.exists()) {
                    appDir.mkdir();
                }

                File file = new File(appDir, filename);
                Uri uri = Uri.fromFile(file);
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    assert bitmap != null;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();
                    Log.d(TAG, "saved to " + file.getAbsolutePath());

                    callback.onResult(uri, true);
                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onResult(uri, false);
                }
            }

            @Override
            public void onFailureImpl(DataSource dataSource) {
            }
        }, CallerThreadExecutor.getInstance());
    }
}

