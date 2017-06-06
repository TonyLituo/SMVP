package com.dhcc.smvp.eventbus;

/**
 * Created by Jinx on 2017/6/6.
 */

public class MessageEvent {

    private String msg;

    public MessageEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
