package com.dhcc.library.util;

import android.content.Context;

/**
 * Created by Jinx on 2017/6/2.
 * <p>
 * 工具类初始化
 */

public class RxUtils {

    private static Context context;

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        RxUtils.context = context;
    }

    public static Context getContext() {
        return context;
    }
}
