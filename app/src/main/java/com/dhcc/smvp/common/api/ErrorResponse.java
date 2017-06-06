package com.dhcc.smvp.common.api;

/**
 * Created by Jinx on 2017/6/6.
 */

public class ErrorResponse  {

    private int rtnCode;

    private String rtnMsg;

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
        return "ErrorResponse{" +
                "rtnCode=" + rtnCode +
                ", rtnMsg='" + rtnMsg + '\'' +
                '}';
    }
}
