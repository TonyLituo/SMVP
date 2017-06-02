package com.dhcc.smvp.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Jinx on 2017/5/31.
 * <p>
 * 自定义SurfaceView
 */

public class MyView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    /*SurfaceHolder*/
    private SurfaceHolder mHolder;
    /*用于绘图的Canvas*/
    private Canvas mCanvas;
    /*子线程标志位*/
    private boolean mIsDrawing;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }

    /**
     * 绘制
     * ctrl + alt + t 添加try/catch
     */
    private void draw() {
        try {
            mCanvas = mHolder.lockCanvas();
            // TODO: 2017/5/31 绘画过程


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mCanvas != null)
                mHolder.unlockCanvasAndPost(mCanvas);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        while (mIsDrawing) {
            draw();
        }
    }
}
