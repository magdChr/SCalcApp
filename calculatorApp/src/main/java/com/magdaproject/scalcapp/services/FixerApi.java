package com.magdaproject.scalcapp.services;

import com.magdaproject.scalcapp.models.BaseCurrencyModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FixerApi {

    @GET("latest")
    Call<BaseCurrencyModel> getCurrencies(
            @Query("access_key") String accessKey,
            @Query("symbols") ArrayList<String> symbols
            );
}

