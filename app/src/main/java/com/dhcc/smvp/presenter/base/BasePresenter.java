package com.dhcc.smvp.presenter.base;


import com.dhcc.smvp.common.api.RetrofitWrapper;
import com.dhcc.smvp.common.api.ResponBean;
import com.dhcc.smvp.model.bean.LoginBean;
import com.dhcc.smvp.view.base.IBaseView;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Jinx on 2017/5/3.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V view;

    protected CompositeDisposable mCompositeDisposable;

    public BasePresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }

    public void attach(V view) {
        this.view = view;
    }

    public void dettach() {
        view = null;
        mCompositeDisposable.clear();
    }


    public V getView() {
        return view;
    }

    /**
     * 网络访问
     *
     * @param map
     */
    public void presenter(Map<String, String> map) {

        new RetrofitWrapper<LoginBean>().post(map, new Observer<ResponBean<LoginBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
                // TODO: 2017/5/25 显示 进度条
                mCompositeDisposable.add(d);

            }

            @Override
            public void onNext(ResponBean<LoginBean> loginBeanResponBean) {

                if (loginBeanResponBean.getRtnCode() == "0000") {
                    // TODO: 2017/5/25 正确

                } else {
                    // TODO: 2017/5/25 错误信息
                }
            }

            @Override
            public void onError(Throwable e) {
                // TODO: 2017/5/25 隐藏进度条
            }

            @Override
            public void onComplete() {
                // TODO: 2017/5/25 隐藏进度条
            }
        });
    }


}
