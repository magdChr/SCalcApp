package com.magdaproject.scalcapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.magdaproject.scalcapp.R;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //android.os.Debug.waitForDebugger();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
}
