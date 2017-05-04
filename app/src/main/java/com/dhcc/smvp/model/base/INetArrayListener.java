package com.dhcc.smvp.model.base;


import org.json.JSONArray;

/**
 * Created by Lituo on 2017/4/18 0018. 14:12 .
 * Mail：tony1994_vip@163.com
 */

public interface INetArrayListener {

    void onSucceed(JSONArray jsonArray);

    void onFailed();

    void onError(int responseCode);
}
