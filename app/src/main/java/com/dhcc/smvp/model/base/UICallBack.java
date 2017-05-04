package com.dhcc.smvp.model.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.dhcc.smvp.model.bean.base.ResParams;
import com.dhcc.smvp.model.bean.base.ResponBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Lituo on 2017/4/5 0005. 16:08 .
 * Mail：tony1994_vip@163.com
 * 方法能在主线程中运行的CallBack
 */


public abstract class UICallBack<T extends ResParams> implements Callback {

    //拿到主线程的handler
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, final IOException e) {
//        LogUtils.e("网络连接失败："+e.getMessage());
        //通过主线程的handler.post方法，发送一个可以在主线程中运行的run方法
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailureUI(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {

//        LogUtils.e("" + response.code());

        //判断是否响应成功
        if (!response.isSuccessful()) {
//            LogUtils.e("错误码：" + response.code());
            //访问错误  根据不同的响应码做出判断
            handler.post(new Runnable() {
                @Override
                public void run() {
                    onError(response.code());
                }
            });
        }
        //拿到json字符串
        String stringBody = response.body().string();
        stringBody = stringBody.trim().replace("\\\"", "\"");
        stringBody = stringBody.trim().replace("\\\\\"", "\\\"");
        if (stringBody.startsWith("\"")) {
            stringBody = stringBody.substring(1);
        }
        if (stringBody.endsWith("\"")) {
            stringBody = stringBody.substring(0, stringBody.length() - 1);
        }

//        LogUtils.e("返回的Json报文：" + body);

        final T t = getResParams(stringBody);
        handler.post(new Runnable() {
            @Override
            public void run() {
                onResponseUI(call, t);
            }
        });

    }

    private T getResParams(String body) {
        if (TextUtils.isEmpty(body)) return null;
        ResponBean<T> responBean = new Gson().fromJson(body, ResponBean.class);
        return responBean.getResParams();

    }
    //抽象三个方法（运行在主线程）


    public abstract void onResponseUI(Call call, T resParams);

    public abstract void onFailureUI(Call call, IOException e);

    public abstract void onError(int responseCode);

}
