package com.dhcc.smvp.presenter.base;


import com.dhcc.smvp.view.base.IBaseView;

/**
 * Created by Jinx on 2017/5/3.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V view;


    public BasePresenter(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }


}
