package com.dhcc.smvp.common.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jinx on 2017/5/23.
 * <p>
 * retrofit访问网络工具类
 */

public class RetrofitUtils {

    /**
     * 单例模式
     */
    private static RetrofitUtils sInstance;

    /**
     * 网络Api
     */

    private ApiService mApiService;
    /**
     * retrofit对象
     */
    private Retrofit mRetrofit;

    private RetrofitUtils() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(OkHttpUtils.getInstance().getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mApiService = mRetrofit.create(ApiService.class);
    }

    public static RetrofitUtils getInstance() {
        if (null == sInstance) {
            synchronized (RetrofitUtils.class) {
                if (null == sInstance) {
                    sInstance = new RetrofitUtils();
                }
            }
        }
        return sInstance;
    }

    public ApiService getApiService() {
        return mApiService;
    }

}
