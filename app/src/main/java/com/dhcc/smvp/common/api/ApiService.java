package com.dhcc.smvp.common.api;

import com.dhcc.smvp.model.bean.Info;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Jinx on 2017/5/24.
 * <p>
 * 网络访问接口
 *
 */

public interface ApiService<T> {

    /**
     * Post requestBody请求数据
     *
     * @param body
     * @return
     */
    @POST(Api.POST_URL)
    Observable<ResponBean<T>> post(@Body RequestBody body);

    /**
     * Post requestBody请求数据   返回参数为JSONArray
     *
     * @param body
     * @return
     */
    @POST(Api.POST_URL)
    Call<ResponBean<T>> postList(@Body RequestBody body);

    /**
     * Get请求
     *
     * @return
     */
    @GET(Api.GET_URL)
    Observable<Info> get();
}
