package com.dhcc.smvp.view.adapter;

/**
 * Created by Jinx on 2017/5/17.
 */

public class MenubBean {
    /**
     * 标题
     */
    private String title;
    /**
     * 图标Resid
     */
    private int label;

    public MenubBean() {
    }

    public MenubBean(String title, int label) {
        this.title = title;
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }
}
