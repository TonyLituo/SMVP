package com.dhcc.smvp.common.api;

import java.io.IOException;

/**
 * Created by Jinx on 2017/6/6.
 */

public class ResultException extends IOException {

    private int rtnCode;

    public ResultException() {
    }

    public ResultException( int rtnCode,String message) {
        super(message);
        this.rtnCode = rtnCode;
    }

    public int getRtnCode() {
        return rtnCode;
    }
}
