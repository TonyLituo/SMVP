package com.dhcc.smvp.view;

import android.support.annotation.NonNull;
import android.view.View;

import com.dhcc.smvp.R;
import com.dhcc.smvp.presenter.LoginPresenter;
import com.dhcc.smvp.view.base.BaseNetActivity;

import butterknife.OnClick;

public class LoginActivity extends BaseNetActivity<ILoginView, LoginPresenter> implements ILoginView {


    @NonNull
    @Override
    protected int getLayoutResID() {
        return R.layout.activity_login;
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
    protected String setToolbarTitle() {
        return "登录";
    }

    @Override
    public void loginSuccess() {

    }


    @OnClick({R.id.btn_login, R.id.error_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                showErrorView();
                break;
            case R.id.error_view:
                showContentView();
                break;
            default:
                break;
        }
    }
}
