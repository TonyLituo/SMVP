package com.dhcc.smvp.common.api;

/**
 * Created by Jinx on 2017/5/24.
 */

public class RetrofitWrapper<T> {
//    /**
//     * 一般post Json请求，返回JSONObject
//     */
//    public void post(Map<String, String> map, Observer<ResponBean<T>> observer) {
//        String request = map2JSONObject(map);
//
//        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
//
//        RetrofitUtils.getInstance()
//                .getApiService()
//                .post(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//
//    /**
//     * 一般post Json请求,返回JSONArray
//     *
//     * @param map
//     * @param observer
//     */
//    public void postList(Map<String, String> map, Observer<ResponBean<T>> observer) {
//        String request = map2JSONObject(map);
//        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);
//
//        // TODO: 2017/5/24
//        RetrofitUtils.getInstance()
//                .getApiService()
//                .post(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//
//    /**
//     * map转为JSONObject字符串
//     *
//     * @param map
//     * @return
//     */
//    private String map2JSONObject(Map<String, String> map) {
//        JSONObject jsonObject = new JSONObject();
//        if (null != map && 0 != map.size()) {
//            jsonObject = new JSONObject(map);
//        }
//        return jsonObject.toString();
//    }


}
