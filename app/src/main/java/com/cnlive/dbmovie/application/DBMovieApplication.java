package com.cnlive.dbmovie.application;

import android.app.Application;

import com.cnlive.dbmovie.utils.DeviceUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by Administrator on 2017/4/16.
 */

public class DBMovieApplication extends Application {

    private volatile static DBMovieApplication singleton;
    private DBMovieApplication (){ }
    public static DBMovieApplication getSingleton() {
        if (singleton == null) {
           synchronized (DBMovieApplication.class) {
              if (singleton == null) {
                 singleton = new DBMovieApplication();
              }
          }
        }
      return singleton;
    }

    public static String ime="";

    @Override
    public void onCreate() {
        super.onCreate();
        singleton=this;
        ImagePipelineConfig config= OkHttpImagePipelineConfigFactory
                .newBuilder(this,new OkHttpClient()).setDownsampleEnabled(true).build();
        Fresco.initialize(this,config);
        ime= DeviceUtils.getIEMI(this);
    }
}
