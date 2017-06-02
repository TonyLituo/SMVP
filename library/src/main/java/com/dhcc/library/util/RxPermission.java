package com.dhcc.library.util;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import static com.dhcc.library.util.RxUtils.getContext;

/**
 * Created by Jinx on 2017/6/2.
 */

public class RxPermission {

    private static void cheack(@NonNull String permission) {
        if (ContextCompat.checkSelfPermission(getContext(), permission)
                != PackageManager.PERMISSION_GRANTED) {

        }
    }

}
