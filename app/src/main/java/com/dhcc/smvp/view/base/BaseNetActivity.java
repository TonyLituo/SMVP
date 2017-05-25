package com.dhcc.smvp.view.base;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.dhcc.smvp.presenter.base.IBasePresenter;

/**
 * Created by Jinx on 2017/5/3.
 */

public abstract class BaseNetActivity<V extends IBaseNetView, P extends IBasePresenter<V>> extends BaseActivity<V, P> implements IBaseNetView {

    protected ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBar = new ProgressBar(this);

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Log.e(tag, message);
    }

    @Override
    public void showErrorView() {
        super.showErrorView();
    }
}
