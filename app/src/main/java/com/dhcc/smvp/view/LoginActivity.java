package com.dhcc.smvp.view;

import android.support.annotation.NonNull;

import com.dhcc.smvp.presenter.LoginPresenter;
import com.dhcc.smvp.view.base.BaseNetActivity;

public class LoginActivity extends BaseNetActivity<ILoginView, LoginPresenter> implements ILoginView {


    @NonNull
    @Override
    protected int getLayoutResID() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @NonNull
    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void loginSuccess() {

    }
}
