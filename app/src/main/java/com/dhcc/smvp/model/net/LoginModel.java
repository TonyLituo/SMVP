package com.dhcc.smvp.model.net;

import com.dhcc.smvp.common.OkHttpUtils;
import com.dhcc.smvp.model.base.INetListener;
import com.dhcc.smvp.model.base.UICallBack;
import com.dhcc.smvp.model.bean.AddressBean;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by Jinx on 2017/5/4.
 */

public class LoginModel implements ILoginModel {


    @Override
    public void login(Map<String, String> map, INetListener<AddressBean> listener) {
        OkHttpUtils.getInstance().doPost(map, new UICallBack<AddressBean>() {
            @Override
            public void onResponseUI(Call call, AddressBean resParams) {

            }

            @Override
            public void onFailureUI(Call call, IOException e) {

            }

            @Override
            public void onError(int responseCode) {

            }
        });
    }


}
