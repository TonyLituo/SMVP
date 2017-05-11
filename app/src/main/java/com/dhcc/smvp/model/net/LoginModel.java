package com.dhcc.smvp.model.net;

import com.dhcc.smvp.common.OkHttpUtils;
import com.dhcc.smvp.model.base.INetListener;
import com.dhcc.smvp.model.base.UICallBack;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by Jinx on 2017/5/4.
 */

public class LoginModel implements ILoginModel {


    @Override
    public void login(Map<String, String> map, final INetListener listener) {

        JSONObject object=new JSONObject(map);

        OkHttpUtils.getInstance().doPost(map, new UICallBack() {
            @Override
            public void onResponseUI(Call call, String body) {
                listener.onSucceed(body);
            }

            @Override
            public void onFailureUI(Call call, IOException e) {
                listener.onFailed(e);
            }

            @Override
            public void onError(int responseCode) {
                listener.onError(responseCode);
            }
        });
    }


}
