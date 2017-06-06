package com.dhcc.smvp.app;

import android.app.Application;

import com.dhcc.library.util.RxUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by Jinx on 2017/5/12.
 */

public class MvpApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RxUtils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
//        registerActivityLifecycleCallbacks(new ActivityCallback());
    }


}
