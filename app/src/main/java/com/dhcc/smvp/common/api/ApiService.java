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
     *
     * 不支持二次泛型   下面两种写法都不对
     *
     *java.lang.IllegalArgumentException:
     * Method return type must not include a type variable or wildcard:
     * io.reactivex.Observable<com.dhcc.traffic.api.ResponBean<T>>
     */
//    /**
//     * Post requestBody请求数据
//     *
//     * @param body
//     * @return
//     */
//    @POST(Api.POST_URL)
//    Observable<ResponBean<T>> post(@Body RequestBody body);
//
//    /**
//     * Post requestBody请求数据   返回参数为JSONArray
//     *
//     * @param body
//     * @return
//     */
//    @POST(Api.POST_URL)
//    Call<ResponBean<T>> postList(@Body RequestBody body);

    /**
     * Get请求
     *
     * @return
     */
    @GET(Api.GET_URL)
    Observable<Info> get();
}
