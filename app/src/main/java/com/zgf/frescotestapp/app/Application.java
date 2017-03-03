package com.zgf.frescotestapp.app;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

import okhttp3.OkHttpClient;

/**
 * Created by zgf on 2017/3/2.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }

    /**
     * 用于高级的初始化方法
     * 1、用于指定缓存的路径
     *  注意：指定缓存路径时需要考虑在 Android6.0 以后的运行时权限问题
     *  在设置缓存路径为 SDK 时，要进行判断手机是否有 SDK，如果没有则使用默认初始化
     *
     */
    private void frescoInitWithCache() {
        Fresco.initialize(this, ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this)
                        .setBaseDirectoryPath(new File(""))// 指定缓存路径
                        .build())
                .build());
    }

    /**
     * 2、用于网络加载的核心库
     *  注意：Fresco 默认使用 HttpURLConnection 作为网络层
     *  这里使用网络层为 Okhttp，导包为 com.facebook.fresco:imagepipeline-okhttp**
     */
    private void frescoInitWithNet() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Fresco.initialize(this, OkHttpImagePipelineConfigFactory
                .newBuilder(this, okHttpClient)
                .setMainDiskCacheConfig(DiskCacheConfig
                        .newBuilder(this)
                        .setBaseDirectoryPath(new File(""))// 指定缓存路径
                        .build())
                .build());
    }

    /**
     * 3、使用自定义的网络库
     *  注意：在使用自己定义的网络库时官方推荐：
     *      为了完全控制网络层的行为，你可以自定义网络层。
     *      继承NetworkFetchProducer, 这个类包含了网络通信。
     *      你也可以选择性地继承FetchState, 这个类是请求时的数据结构描述。
     */
    private void frescoInitWithCustomerNet() {
        Fresco.initialize(this, ImagePipelineConfig
                .newBuilder(this)
                .setNetworkFetcher(null)// 这里传入自定义的网络层
                .build());
    }
}
