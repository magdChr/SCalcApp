package com.magdaproject.scalcapp.viewmodel;

import android.app.Application;

import com.magdaproject.scalcapp.models.BaseCurrencyModel;
import com.magdaproject.scalcapp.repository.FixerRepository;
import com.magdaproject.scalcapp.services.ApiResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CalculatorViewModel extends AndroidViewModel {

    private LiveData<ApiResponse<BaseCurrencyModel>> currencies = new MutableLiveData<>();

    private MutableLiveData<Integer> currentValue = new MutableLiveData<>();

    private MutableLiveData<Integer> previousValue = new MutableLiveData<>();

    private MutableLiveData<Integer> tempValue = new MutableLiveData<>();

    private MutableLiveData<String> screenValue = new MutableLiveData<>();

    private MutableLiveData<String> operator = new MutableLiveData<>();

    private MutableLiveData<Boolean> isOperatorClicked = new MutableLiveData<>();

    public CalculatorViewModel(@NonNull Application application) {
        super(application);
        currentValue.setValue(0);
        previousValue.setValue(0);
        tempValue.setValue(0);
        isOperatorClicked.setValue(false);
        operator.setValue("");

    }

    public LiveData<ApiResponse<BaseCurrencyModel>> getCurrencies() {
        return currencies;
    }

    public void retreiveCurrencies() {
        currencies = FixerRepository.getInstance().getLiveCurrencies();
    }

    public LiveData<Integer> getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue.setValue(currentValue);
    }

    public MutableLiveData<Integer> getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(int previousValue) {
        this.previousValue.setValue(previousValue);
    }

    public MutableLiveData<String> getScreenValue() {
        return screenValue;
    }

    public void setScreenValue(String screenValue) {
        this.screenValue.setValue(screenValue);
    }


    public MutableLiveData<Integer> getTempValue() {
        return tempValue;
    }

    public void setTempValue(int tempValue) {
        this.tempValue.setValue(tempValue);
    }

    public MutableLiveData<String> getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator.setValue(operator);
    }


    public MutableLiveData<Boolean> getIsOperatorClicked() {
        return isOperatorClicked;
    }

    public void setIsOperatorClicked(boolean isOperatorClicked) {
        this.isOperatorClicked.setValue(isOperatorClicked);
    }


    public void calculate(String action){
        isOperatorClicked.setValue(true);
        switch(operator.getValue()){
            case "+":
                currentValue.setValue(tempValue.getValue()+currentValue.getValue());
                break;
            case "-":
                currentValue.setValue(tempValue.getValue()-currentValue.getValue());
                break;
            case "*":
                currentValue.setValue(tempValue.getValue()*currentValue.getValue());
                break;
            case "/":
                currentValue.setValue(tempValue.getValue()/currentValue.getValue());
                break;
        }
        previousValue.setValue(currentValue.getValue());
        switch (action) {
            case "=":
                screenValue.setValue(Integer.toString(currentValue.getValue()));
                break;
            default:
                screenValue.setValue(Integer.toString(currentValue.getValue()) + action);
                break;
        }
            operator.setValue(action);
        }


}
