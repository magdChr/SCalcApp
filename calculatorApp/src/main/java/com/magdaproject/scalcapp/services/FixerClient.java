package com.magdaproject.scalcapp.services;

import com.magdaproject.scalcapp.models.BaseCurrencyModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public class FixerClient {


    public static final String BASE_URL = "http://data.fixer.io/api/";
    private static Retrofit fixerClientInstance;


    public static Retrofit getFixerClientInstance() {
        if (fixerClientInstance == null) {
            fixerClientInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).
                            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return fixerClientInstance;
    }
}

