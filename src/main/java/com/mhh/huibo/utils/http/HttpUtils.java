package com.mhh.huibo.utils.http;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class HttpUtils {

    public static final String JSON = "application/json; charset=utf-8";
    public static final String FORM = "application/x-www-from-urlencoded";


    // 重载方式给params设置默认值
    public static String get(String url) throws IOException {
        return get(url, null);
    }

    public static String get(String url, String params) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request req;
        if (params == null) {
            req = new Request.Builder().url(url).get().build();
        } else {
            req = new Request.Builder().url(url + "?" + params).get().build();
        }
        Response rsp = client.newCall(req).execute();
        System.out.println("响应码：" + rsp.code());
        System.out.println("响应头：" + rsp.headers());
        return Objects.requireNonNull(rsp.body()).string();
    }

    public static String post(String url, String params) throws IOException {
        // 设置请求参数类型，准备好请求参数body
        MediaType type = MediaType.parse(JSON);
        RequestBody body = RequestBody.create(type, params);

        // 创建client
        OkHttpClient client = new OkHttpClient();
        // 创建请求
        Request req = new Request.Builder().url(url).post(body).build();
        // 使用client 发送请求
        Response rsp = client.newCall(req).execute();
        System.out.println("响应码：" + rsp.code());
        System.out.println("响应头：" + rsp.headers());
        System.out.println("-------------");
        return Objects.requireNonNull(rsp.body()).string();
    }
}
