package com.dhcc.smvp.model.bean;

import com.dhcc.smvp.model.bean.base.ResParams;

/**
 * Created by Jinx on 2017/6/6.
 */

public class TestBean extends ResParams {

    private int id;

    private String name;

    public TestBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
