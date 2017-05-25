package com.dhcc.smvp.common;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

import java.io.File;

/**
 * Created by Jinx on 2017/5/19.
 * <p>
 * Banner加载图片
 */

public class PicassoImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        if (path instanceof File) {
            Picasso.with(context).load((File) path).into(imageView);
        } else if (path instanceof Uri) {
            Picasso.with(context).load((Uri) path).into(imageView);
        } else if (path instanceof String) {
            Picasso.with(context).load((String) path).into(imageView);
        } else if (path instanceof Integer) {
            Picasso.with(context).load((Integer) path).into(imageView);
        }
    }
}
