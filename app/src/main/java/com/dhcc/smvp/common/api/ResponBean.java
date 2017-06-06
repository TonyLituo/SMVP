package com.dhcc.smvp.common.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lituo on 2017/4/13 0013. 11:47 .
 * Mail：tony1994_vip@163.com
 * 网络访问响应的实体
 * <p>
 * <p>
 * <p>
 * 数据请求结果统一预处理实体类（要求服务器返回数据统一格式）
 * 如数据格式为：
 * <p>
 * {
 * "rtnCode": 0,
 * "rtnMsg": "成功",
 * "resParams": []
 * }
 */

public class ResponBean<T> {


    /**
     * resParams :
     * rtnCode : 0000
     * rtnMsg : 交易成功
     */
    @SerializedName("resParams")
    private T resParams;

    private int rtnCode;

    private String rtnMsg;

    public T getResParams() {
        return resParams;
    }

    public void setResParams(T resParams) {
        this.resParams = resParams;
    }

    public int getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(int rtnCode) {
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
                ", rtnCode=" + rtnCode +
                ", rtnMsg='" + rtnMsg + '\'' +
                '}';
    }
}
