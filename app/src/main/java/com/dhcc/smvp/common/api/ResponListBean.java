package com.dhcc.smvp.common.api;

import java.util.List;

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

public class ResponListBean<T> {


    /**
     * resParams :[]
     * rtnCode : 0000
     * rtnMsg : 交易成功
     */

    private List<T> resParams;

    private String rtnCode;

    private String rtnMsg;

    public List<T> getResParams() {
        return resParams;
    }

    public void setResParams(List<T> resParams) {
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
        return "ResponListBean{" +
                "resParams=" + resParams +
                ", rtnCode='" + rtnCode + '\'' +
                ", rtnMsg='" + rtnMsg + '\'' +
                '}';
    }
}
