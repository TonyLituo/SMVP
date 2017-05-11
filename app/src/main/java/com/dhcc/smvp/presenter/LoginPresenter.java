package com.dhcc.smvp.presenter;

import com.dhcc.smvp.model.base.INetListener;
import com.dhcc.smvp.model.bean.AddressBean;
import com.dhcc.smvp.model.bean.base.ResponBean;
import com.dhcc.smvp.model.net.ILoginModel;
import com.dhcc.smvp.model.net.LoginModel;
import com.dhcc.smvp.presenter.base.BasePresenter;
import com.dhcc.smvp.view.ILoginView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Jinx on 2017/5/3.
 */

public class LoginPresenter extends BasePresenter<ILoginView> {

    private ILoginModel mModel;

    public LoginPresenter(ILoginView view) {
        super(view);
        mModel = new LoginModel();
    }


    public void login(Map<String, String> map) {
        getView().showProgressBar();
        mModel.login(map, new INetListener() {
            @Override
            public void onSucceed(String body) {
                ResponBean<AddressBean> responBean = new Gson().fromJson(body, ResponBean.class);
                AddressBean bean = responBean.getResParams();
                getView().hideProgressBar();
            }

            @Override
            public void onFailed(IOException e) {
                getView().hideProgressBar();
                getView().showMessage(e.getMessage());
            }

            @Override
            public void onError(int responseCode) {
                getView().hideProgressBar();
                getView().showMessage("错误码：" + responseCode);
            }
        });
    }
}
