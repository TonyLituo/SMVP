package com.dhcc.smvp.model.bean;

import com.dhcc.smvp.model.bean.base.ResParams;

import java.io.Serializable;

/**
 * Created by Lituo on 2017/4/15 0015. 16:22 .
 * Mail：tony1994_vip@163.com
 * 查询地址回文
 */

public class AddressBean extends ResParams implements Serializable, Comparable<AddressBean> {

    /**
     * contanct : 暴走萝莉
     * phone : 18766662222
     * province : 四川省
     * city : 绵阳市
     * area : 三台县
     * addrSeqn : 8
     * detailAddr : 你猜
     * defaultAddr : 0
     * postCode :100086
     * email
     */

    private String contanct;
    private String phone;
    private String province;
    private String city;
    private String area;
    private String addrSeqn;
    private String detailAddr;
    private String defaultAddr;
    private String postCode;
    private String email;
    private boolean isDefault;


    public String getContanct() {
        return contanct;
    }

    public void setContanct(String contanct) {
        this.contanct = contanct;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddrSeqn() {
        return addrSeqn;
    }

    public void setAddrSeqn(String addrSeqn) {
        this.addrSeqn = addrSeqn;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    public String getDefaultAddr() {
        return defaultAddr;
    }

    public void setDefaultAddr(String defaultAddr) {
        this.defaultAddr = defaultAddr;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "AddressBean{" +
                "contanct='" + contanct + '\'' +
                ", phone='" + phone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", addrSeqn='" + addrSeqn + '\'' +
                ", detailAddr='" + detailAddr + '\'' +
                ", defaultAddr='" + defaultAddr + '\'' +
                ", postCode='" + postCode + '\'' +
                ", email='" + email + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }

    @Override
    public int compareTo(AddressBean o) {
        return -this.defaultAddr.compareTo(o.defaultAddr);
    }
}
