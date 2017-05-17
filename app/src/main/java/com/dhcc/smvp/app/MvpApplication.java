package com.dhcc.smvp.app;

import android.app.Application;

/**
 * Created by Jinx on 2017/5/12.
 */

public class MvpApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        registerActivityLifecycleCallbacks(new ActivityCallback());
//        setTheme(R.style.RedTheme);
    }

    @Override
    public void setTheme(int resid) {
        super.setTheme(resid);
    }
}
