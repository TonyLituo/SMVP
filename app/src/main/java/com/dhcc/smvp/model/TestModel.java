package com.dhcc.smvp.model;

import android.util.Log;

import com.dhcc.smvp.common.api.RetrofitWrapper;
import com.dhcc.smvp.common.api.OkHttpUtils;
import com.dhcc.smvp.common.api.ResponBean;
import com.dhcc.smvp.common.api.RetrofitUtils;
import com.dhcc.smvp.model.bean.Info;
import com.dhcc.smvp.model.bean.LoginBean;

import java.io.IOException;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jinx on 2017/5/23.
 */

public class TestModel {

    private CompositeDisposable mCompositeDisposable;

    public void getOkArea() {
        OkHttpUtils.getInstance().doGet("Area", new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                String s = response.body().string();
                Log.e("Response", s);
            }
        });
    }

    public void getArea(Observer<Info> observer) {
        RetrofitUtils.getInstance()
                .getApiService()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    void login(Map<String, String> map) {

        new RetrofitWrapper<LoginBean>().post(map, new Observer<ResponBean<LoginBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
//// TODO: 2017/5/25 显示 进度条
                mCompositeDisposable.add(d);
            }

            @Override
            public void onNext(ResponBean<LoginBean> loginBeanResponBean) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
// TODO: 2017/5/25 隐藏进度条
            }
        });
    }

}
