package com.dhcc.smvp.common.api;

import android.text.TextUtils;

import com.dhcc.smvp.BuildConfig;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Jinx on 2017/5/3.
 */
public class OkHttpUtils {
    /**
     * 默认超时时间
     */
    private static final int DEFAULT_TIMEOUT = 5;

    private OkHttpClient client;
    /**
     * 唯一实例
     */
    private static OkHttpUtils sInstance;

    private OkHttpUtils() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //如果不是在正式包，添加拦截 打印响应json
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor(
                    new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            if (TextUtils.isEmpty(message)) return;
                            String s = message.substring(0, 1);
                            //如果收到响应是json才打印
                            if ("{".equals(s) || "[".equals(s)) {
                                Logger.d("收到响应: "+message);
                                Logger.json(message);
                            }
                        }
                    });

            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }

        client = builder
                .addInterceptor(new RequestInterceptor())
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpUtils getInstance() {
        if (null == sInstance) {
            synchronized (OkHttpUtils.class) {
                if (null == sInstance) {
                    sInstance = new OkHttpUtils();
                }
            }
        }
        return sInstance;
    }


    public OkHttpClient getClient() {
        return client;
    }

    /**
     * Get请求
     *
     * @param callback
     */
    public void doGet(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(Api.BASE_URL + url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    /**
     * Post请求发送键值对数据
     *
     * @param mapParams
     * @param callback
     */
    public void doPost(Map<String, String> mapParams, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : mapParams.keySet()) {
            builder.add(key, mapParams.get(key));
        }
        Request request = new Request.Builder()
                .url(Api.BASE_URL)
                .post(builder.build())
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    /**
     * Post请求发送JSON数据
     *
     * @param jsonParams
     * @param callback
     */
    public void doPost(String jsonParams, Callback callback) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8")
                , jsonParams);
        Request request = new Request.Builder()
                .url(Api.BASE_URL)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    /**
     * 上传文件
     *
     * @param pathName
     * @param fileName
     * @param callback
     */
    public void doFile(String pathName, String fileName, Callback callback) {
        //判断文件类型mediaType
        MediaType mediaType = MediaType.parse(judgeType(pathName));
        //创建文件参数
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(mediaType.type(), fileName,
                        RequestBody.create(mediaType, new File(pathName)));
        //发出请求参数
        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + "9199fdef135c122")
                .url(Api.UP_FILE_URL)
                .post(builder.build())
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    /**
     * 根据文件路径判断MediaType
     *
     * @param path
     * @return
     */
    private String judgeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = fileNameMap.getContentTypeFor(path);
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }

    /**
     * 下载文件
     *
     * @param fileDir
     * @param fileName
     */
    public void downFile(final String fileDir, final String fileName) {
        Request request = new Request.Builder()
                .url(Api.DOWN_FILE_URL)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();
                    File file = new File(fileDir, fileName);
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) is.close();
                    if (fos != null) fos.close();
                }
            }
        });
    }
}
