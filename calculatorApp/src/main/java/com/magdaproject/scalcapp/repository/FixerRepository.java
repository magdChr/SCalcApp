package com.magdaproject.scalcapp.repository;

import com.magdaproject.scalcapp.helpers.CurrencyHelper;
import com.magdaproject.scalcapp.models.BaseCurrencyModel;
import com.magdaproject.scalcapp.services.ApiResponse;
import com.magdaproject.scalcapp.services.FixerApi;
import com.magdaproject.scalcapp.services.FixerClient;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FixerRepository {

    private FixerApi mFixerApiService;
    private static FixerRepository sInstance;

    private MutableLiveData<ApiResponse<BaseCurrencyModel>> currencies = new MutableLiveData<>();
    private String API_KEY = "c8f1091eb7655c531b52d82d18d22cc3";

    private FixerRepository() {
        mFixerApiService = FixerClient.getFixerClientInstance().create(FixerApi.class);
    }

    public synchronized static FixerRepository getInstance() {
        if (sInstance == null) {
            sInstance = new FixerRepository();
        }
        return sInstance;
    }

    public MutableLiveData<ApiResponse<BaseCurrencyModel>> getCurrencies() {
        return currencies;
    }

    public MutableLiveData<ApiResponse<BaseCurrencyModel>> getLiveCurrencies() {
        Call<BaseCurrencyModel> call = mFixerApiService.getCurrencies(API_KEY, CurrencyHelper.constructCurrenciesList());
        call.enqueue(new Callback<BaseCurrencyModel>() {

            @Override
            public void onResponse(Call<BaseCurrencyModel> call, Response<BaseCurrencyModel> response) {
                currencies.setValue(ApiResponse.success(response.body()));

            }

            @Override
            public void onFailure(Call<BaseCurrencyModel> call, Throwable t) {
                currencies.setValue(ApiResponse.error(t.getMessage(), null));
            }
        });
        return currencies;
    }
}
