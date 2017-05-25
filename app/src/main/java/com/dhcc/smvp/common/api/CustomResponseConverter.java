package com.dhcc.smvp.common.api;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Jinx on 2017/5/24.
 * <p>
 * 重写GsonResponseConverter
 */

public class CustomResponseConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    public CustomResponseConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }


    @Override
    public T convert(ResponseBody value) throws IOException {
        // TODO: 2017/5/24 自定义解析 参照  http://www.jianshu.com/p/2263242fa02d
        return null;
    }
}
