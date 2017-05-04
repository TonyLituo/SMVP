package com.dhcc.smvp.view.base;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.dhcc.smvp.presenter.base.IBasePresenter;

/**
 * Created by Jinx on 2017/5/3.
 */

public abstract class BaseActivity<V extends IBaseView, P extends IBasePresenter<V>> extends AppCompatActivity implements IBaseView {

    //MvpActivity
    protected P presenter;

    protected  String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tag = this.getClass().getSimpleName();

        setContentView(getLayoutResID());
        initView();

        presenter = createPresenter();
    }

    //布局ID
    @LayoutRes
    @NonNull
    protected abstract int getLayoutResID();

    protected abstract void initView();

    @NonNull
    protected abstract P createPresenter();
}
