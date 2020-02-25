package com.magdaproject.scalcapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.magdaproject.scalcapp.R;
import com.magdaproject.scalcapp.databinding.ActivityCalculatorBinding;
import com.magdaproject.scalcapp.listeners.ActionClickListener;
import com.magdaproject.scalcapp.models.BaseCurrencyModel;
import com.magdaproject.scalcapp.services.ApiResponse;
import com.magdaproject.scalcapp.viewmodel.CalculatorViewModel;

public class CalculatorActivity extends AppCompatActivity {

    private ActivityCalculatorBinding mActivityCalculatorBinding;

    private CalculatorViewModel calculatorViewModel;

    private boolean isDecimal;

    private String operator = "";

    private boolean isOperatorClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //android.os.Debug.waitForDebugger();
        super.onCreate(savedInstanceState);
        mActivityCalculatorBinding = DataBindingUtil.setContentView(this, R.layout.activity_calculator);
        setSupportActionBar((Toolbar) mActivityCalculatorBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mActivityCalculatorBinding.setClickListener(mActionClickListener);
        calculatorViewModel = ViewModelProviders.of(this).get(CalculatorViewModel.class);
        calculatorViewModel.retreiveCurrencies();
        calculatorViewModel.getCurrencies().observe(this, new Observer<ApiResponse<BaseCurrencyModel>>() {
            @Override
            public void onChanged(ApiResponse<BaseCurrencyModel> baseCurrencyModelApiResponse) {
                if (baseCurrencyModelApiResponse.getStatus().equals(ApiResponse.Status.ERROR)) {
                } else if (baseCurrencyModelApiResponse.getStatus().equals(ApiResponse.Status.SUCCESS)) {
                    baseCurrencyModelApiResponse.getData().getRates();

                }
            }
        });
        calculatorViewModel.getScreenValue().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mActivityCalculatorBinding.calculatorScreen.setText(s);
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private ActionClickListener mActionClickListener = new ActionClickListener() {
        @Override
        public void onItemClicked(View v) {
            switch (v.getId()) {
                case R.id.btn_currency:
                    calculatorViewModel.setScreenValue("currency_change");
                    break;
                case R.id.btn_clearAll:
                    calculatorViewModel.setScreenValue("");
                    calculatorViewModel.setCurrentValue(0);
                    calculatorViewModel.setPreviousValue(0);
                    calculatorViewModel.setTempValue(0);
                    calculatorViewModel.setOperator("");
                    calculatorViewModel.setIsOperatorClicked(false);
                    // currentValue = "";
                    break;
                case R.id.btn_clear:
                    if (calculatorViewModel.getScreenValue().getValue().length() > 0) {
                        calculatorViewModel.setScreenValue(calculatorViewModel.getScreenValue().getValue().substring(0, calculatorViewModel.getScreenValue().getValue().length() - 1));

                    }
                    break;
                case R.id.btn_equals:

                    calculatorViewModel.calculate(((Button) v).getText().toString());

                    break;
                case R.id.btn_plus:
                    calculatorViewModel.calculate(((Button) v).getText().toString());


                    break;

                case R.id.btn_minus:

                    calculatorViewModel.calculate(((Button) v).getText().toString());


                    break;
                case R.id.btn_multi:
                    calculatorViewModel.calculate(((Button) v).getText().toString());


                    break;
                case R.id.btn_div:
                    calculatorViewModel.calculate(((Button) v).getText().toString());


                    break;
                case R.id.btn_dec:

                default:
                    if(calculatorViewModel.getIsOperatorClicked().getValue()){
                        calculatorViewModel.setTempValue(calculatorViewModel.getPreviousValue().getValue());
                        calculatorViewModel.setPreviousValue(0);
                    }
                    calculatorViewModel.setCurrentValue(Integer.parseInt(calculatorViewModel.getPreviousValue().getValue().toString() + ((Button) v).getText().toString()));
                    calculatorViewModel.setScreenValue((calculatorViewModel.getScreenValue().getValue() != null ? calculatorViewModel.getScreenValue().getValue() : "") + ((Button) v).getText().toString());
                    calculatorViewModel.setPreviousValue(calculatorViewModel.getCurrentValue().getValue());
                    calculatorViewModel.setIsOperatorClicked(false);

                    break;
            }
        }
    };

  private int getOperator(){
      return Integer.parseInt(operator);
  }
}
