package com.dhcc.smvp.model.net;

import com.dhcc.smvp.model.base.IBaseModel;
import com.dhcc.smvp.model.base.INetListener;

import java.util.Map;

/**
 * Created by Jinx on 2017/5/4.
 */

public interface ILoginModel extends IBaseModel {

    void login(Map<String, String> map, INetListener listener);
}
