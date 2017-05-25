package com.dhcc.smvp.common.api;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jinx on 2017/5/24.
 * <p>
 * 过滤器  添加请求头信息
 */

public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request()
                .newBuilder()
                .addHeader("DAIWAN-API-TOKEN", Api.TOKEN)
                .build();

//        Log.e("Jinx", "request:" + request.toString());
//
//        Log.e("Jinx", "request headers:" + request.headers().toString());
        return chain.proceed(request);
    }
}
