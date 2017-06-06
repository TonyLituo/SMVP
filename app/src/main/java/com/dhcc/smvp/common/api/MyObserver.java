package com.dhcc.smvp.common.api;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;

/**
 * Created by Jinx on 2017/6/6.
 */

public abstract class MyObserver<T> implements Observer<T> {
    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        //在这里做全局的错误处理
        if (e instanceof ConnectException ||
                e instanceof SocketTimeoutException ||
                e instanceof TimeoutException) {
            //网络错误
            error(-9999);
        } else if (e instanceof ResultException) {
            //自定义的ResultException
            //由于返回200,300返回格式不统一的问题，自定义GsonResponseBodyConverter凡是300的直接抛异常
            error(((ResultException) e).getRtnCode());
        }else {
            error(-1);
        }
    }

    public abstract void error(int code);

}
