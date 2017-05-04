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
    public void error(int responseCode) {
        Log.e(tag, "错误码 responseCode==" + responseCode);
    }

    @Override
    public void failure() {
        Log.e(tag, "网络连接失败，请检查网络连接...");
    }

}
