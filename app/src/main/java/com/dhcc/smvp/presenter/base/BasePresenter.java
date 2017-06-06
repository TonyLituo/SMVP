package com.dhcc.smvp.presenter.base;


import com.dhcc.smvp.view.base.IBaseView;

import io.reactivex.disposables.CompositeDisposable;

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

   }
