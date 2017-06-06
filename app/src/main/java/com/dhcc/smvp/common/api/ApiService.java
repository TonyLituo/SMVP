package com.dhcc.smvp.common.api;

import com.dhcc.smvp.model.bean.Info;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Jinx on 2017/5/24.
 * <p>
 * 网络访问接口
 */

public interface ApiService {


    /**
     * retrofit
     * <p>
     * 不支持二次泛型   下面两种写法都不对
     * <p>
     * java.lang.IllegalArgumentException:
     * Method return type must not include a type variable or wildcard:
     * io.reactivex.Observable<com.dhcc.traffic.api.ResponBean<T>>
     */
   /* @POST(Api.POST_URL)
    Observable<ResponBean<T>> post(@Body RequestBody body);


    @POST(Api.POST_URL)
    Call<ResponBean<T>> postList(@Body RequestBody body);*/

    /**
     * Get请求
     *
     * @return
     */
    @GET(Api.GET_URL)
    Observable<Info> get();
}
