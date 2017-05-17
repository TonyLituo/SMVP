package com.dhcc.smvp.view.base;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

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

        //把设置布局文件的操作交给继承的子类
        ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View parentView = contentFrameLayout.getChildAt(0);
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.setFitsSystemWindows(true);
        }

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
