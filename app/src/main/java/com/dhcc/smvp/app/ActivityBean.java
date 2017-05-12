package com.dhcc.smvp.app;


import java.io.Serializable;

import butterknife.Unbinder;

/**
 * Created by Jinx on 2017/5/12.
 */

public class ActivityBean implements Serializable {
    private Unbinder unbinder;

    public Unbinder getUnbinder() {
        return unbinder;
    }

    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }
}
