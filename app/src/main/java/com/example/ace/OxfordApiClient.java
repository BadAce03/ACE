package com.example.ace;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OxfordApiClient {
    private static final String
            base_url="https://od-api.oxforddictionaries.com/api/v2/";
    private static final String APP_ID = "34548f3e";
    private static final String APP_KEY = "957aff67c473ccfdafdbdd73556d1930";

    private static Retrofit retrofit;
    public static Retrofit getAPIClient() {
        if (retrofit == null) {
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

            okHttpClient.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();
                    Request.Builder builder = originalRequest.newBuilder().header("34548f3e", APP_ID).header("957aff67c473ccfdafdbdd73556d1930", APP_KEY);
                    Request newRequest = builder.build();
                    return chain.proceed(newRequest);
                }
            });
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
