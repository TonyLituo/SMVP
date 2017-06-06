package com.dhcc.smvp.model;

import android.util.Log;

import com.dhcc.smvp.common.api.OkHttpUtils;
import com.dhcc.smvp.common.api.RetrofitUtils;
import com.dhcc.smvp.model.bean.Info;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
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

}
