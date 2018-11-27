package com.example.jianw.flickr_search;

import android.app.Application;
import android.content.Context;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jian1.w on 11/24/2018.
 */

public class CustomApplication extends Application {
    private static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        Set<RequestListener> requestListeners = new HashSet<>();
        requestListeners.add(new RequestLoggingListener());
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                // other setters
                .setRequestListeners(requestListeners)
                .build();
        Fresco.initialize(this, config);
        FLog.setMinimumLoggingLevel(FLog.VERBOSE);
        appContext = getApplicationContext();
    }
    public static Context getAppContext() {
        return appContext;
    }
}
