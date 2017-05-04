package com.dhcc.smvp.model.base;


import com.dhcc.smvp.model.bean.base.ResParams;

/**
 * Created by Lituo on 2017/4/10 0010. 20:09 .
 * Mail：tony1994_vip@163.com
 * 网络访问Model监听
 */

public interface INetListener<T extends ResParams> {

    void onSucceed(T resParams);

    void onFailed();

    void onError(int responseCode);
}
