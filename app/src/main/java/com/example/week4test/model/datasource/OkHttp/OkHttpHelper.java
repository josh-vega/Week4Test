package com.example.week4test.model.datasource.OkHttp;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpHelper {

    public  static void asyncOkHttpApiCall(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            String jsonResponse;
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: ", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                jsonResponse = response.body().string();
                Log.d("TAG", "onResponse: " + jsonResponse);
            }
        });

    }

    public static void syncOkHttpApiCall(String url){
        final OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    String jsonResponse = response.body().string();
                    Log.d("TAG", "run: " + jsonResponse);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    //build okhttp client with interceptor
    public static OkHttpClient okhttpWithIntercepterClient(){
        HttpLoggingInterceptor httpLoggingInterceptor
                = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static void asyncWithIntercept(String url){
        OkHttpClient okHttpClient = okhttpWithIntercepterClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("TAG", "onResponse: " + response.body().string());
            }
        });
    }
}
