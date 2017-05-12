package com.dhcc.smvp.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jinx on 2017/5/12.
 */

public class ActivityCallback implements Application.ActivityLifecycleCallbacks {


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        ActivityBean bean = new ActivityBean();
        Unbinder unbinder = ButterKnife.bind(activity);
        bean.setUnbinder(unbinder);
        activity.getIntent().putExtra("ActivityBean", bean);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        ActivityBean bean = (ActivityBean) activity.getIntent().getSerializableExtra("ActivityBean");
        bean.getUnbinder().unbind();
    }
}
