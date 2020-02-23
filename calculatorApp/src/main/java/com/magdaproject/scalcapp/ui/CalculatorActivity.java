package com.magdaproject.scalcapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.magdaproject.scalcapp.R;
import com.magdaproject.scalcapp.databinding.ActivityCalculatorBinding;
import com.magdaproject.scalcapp.listeners.ActionClickListener;

public class CalculatorActivity extends AppCompatActivity {

    private ActivityCalculatorBinding mActivityCalculatorBinding;
    private String currentValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //android.os.Debug.waitForDebugger();
        super.onCreate(savedInstanceState);
        mActivityCalculatorBinding = DataBindingUtil.setContentView(this, R.layout.activity_calculator);
        setSupportActionBar((Toolbar) mActivityCalculatorBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mActivityCalculatorBinding.setClickListener(mActionClickListener);

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
                    mActivityCalculatorBinding.calculatorScreen.setText("currency_call");
                    break;
                case R.id.btn_clearAll:
                    mActivityCalculatorBinding.calculatorScreen.setText("");
                   // currentValue = "";
                    break;
                case R.id.btn_clear:
                    if(currentValue.length() > 0)
                    mActivityCalculatorBinding.calculatorScreen.setText(currentValue.substring(0,currentValue.length()-1));

                    break;
                default:
                    mActivityCalculatorBinding.calculatorScreen.setText(currentValue + ((Button) v).getText().toString());
                  //  currentValue = mActivityCalculatorBinding.calculatorScreen.getText().toString();
                    break;
            }currentValue = mActivityCalculatorBinding.calculatorScreen.getText().toString();
            //  break;
//              case R.id.btn_two:
//                  mActivityCalculatorBinding.calculatorScreen.setText("2");
//                  break;
//              case R.id.btn_three:
//                  mActivityCalculatorBinding.calculatorScreen.setText("3");
//                  break;
//              case R.id.btn_four:
//                  mActivityCalculatorBinding.calculatorScreen.setText("4");
//                  break;
//              case R.id.btn_five:
//                  mActivityCalculatorBinding.calculatorScreen.setText("5");
//                  break;
//              case R.id.btn_six:
//                  mActivityCalculatorBinding.calculatorScreen.setText("6");
//                  break;
//              case R.id.btn_seven:
//                  mActivityCalculatorBinding.calculatorScreen.setText("7");
//                  break;
//              case R.id.btn_eight:
//                  mActivityCalculatorBinding.calculatorScreen.setText("8");
//                  break;
//              case R.id.btn_nine:
//                  mActivityCalculatorBinding.calculatorScreen.setText("9");
//                  break;
//              case R.id.btn_zero:
//                  mActivityCalculatorBinding.calculatorScreen.setText("0");
//                  break;
        }
    };
    // };
}
