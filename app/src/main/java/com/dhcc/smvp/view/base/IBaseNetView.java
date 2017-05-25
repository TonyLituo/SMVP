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
     * 显示错误信息
     *
     * @param message
     */
    void showMessage(String message);

    void showErrorView();
}
