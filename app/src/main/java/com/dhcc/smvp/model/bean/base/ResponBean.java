package com.dhcc.smvp.model.bean.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lituo on 2017/4/13 0013. 11:47 .
 * Mail：tony1994_vip@163.com
 * 网络访问响应的实体
 */

public class ResponBean<T extends ResParams> {


    /**
     * ResParams :
     * rtnCode : 0000
     * RtnMsg : 交易成功
     */

    private T resParams;
    @SerializedName("RtnCode")
    private String rtnCode;
    @SerializedName("RtnMsg")
    private String rtnMsg;

    public T getResParams() {
        return resParams;
    }

    public void setResParams(T resParams) {
        this.resParams = resParams;
    }

    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }


    @Override
    public String toString() {
        return "ResponBean{" +
                "resParams=" + resParams +
                ", rtnCode='" + rtnCode + '\'' +
                ", rtnMsg='" + rtnMsg + '\'' +
                '}';
    }
}
