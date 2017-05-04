package com.dhcc.smvp.view.base;

/**
 * Created by Jinx on 2017/5/3.
 */

public interface IBaseNetView extends IBaseView {
    /**
     * 显示进度条
     */
    void showProgressBar();

    /**
     * 隐藏进度条
     */
    void hideProgressBar();

    /**
     * 网络错误
     *
     * @param responseCode 错误码
     */
    void onError(int responseCode);

    /**
     * 无网络
     */
    void onFailed();
}
