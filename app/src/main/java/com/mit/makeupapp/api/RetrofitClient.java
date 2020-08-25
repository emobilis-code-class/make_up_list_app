package com.mit.makeupapp.api;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
// * Singleton to get an instance of the api client
*/
public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {
        String baseUrl="http://makeup-api.herokuapp.com/api/";
        //increase the time out 60 - its the server we are fetchig the data from is slow
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        /*----*/
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
