package com.dhcc.smvp.common.api;


import android.util.Log;

import com.dhcc.smvp.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jinx on 2017/5/24.
 * <p>
 *     日志拦截器
 * 过滤器  添加请求头信息
 */

public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request()
                .newBuilder()
                .addHeader("DAIWAN-API-TOKEN", Api.TOKEN)
//                .addHeader("Content-Type", "application/json; charset=utf-8")
                .build();

        if (BuildConfig.DEBUG) {

            Log.e("Interceptor", String.format("发送请求: %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));
        }
        return chain.proceed(request);
    }
}
