package com.example.mytestingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewResultActivity extends AppCompatActivity {

    private TextView tvInput2,tvType2,tvValue2,tvDividends2,tvTotalValue,tvPreValue;
    private String type = Constants.PERCENTAGE;
    private String percentage = "0.0";
    private String dividend = "1";
    private String input = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);
        initialize();
        displayValues();
    }

    private void initialize() {
        tvInput2 = findViewById(R.id.tvInput2);
        tvType2 = findViewById(R.id.tvType2);
        tvValue2 = findViewById(R.id.tvValue2);
        tvDividends2 = findViewById(R.id.tvDividends2);
        tvTotalValue = findViewById(R.id.tvTotalValue);
        tvPreValue = findViewById(R.id.tvPreValue);
    }

    private void displayValues() {
        input = getIntent().getStringExtra(Constants.INPUT);
        type = getIntent().getStringExtra(Constants.TYPE);
        percentage =  getIntent().getStringExtra(Constants.PERCENTAGE);
        dividend =  getIntent().getStringExtra(Constants.DIVIDEND);

        tvInput2.setText(input);
        tvType2.setText(type);
        tvValue2.setText(percentage);
        tvDividends2.setText(dividend);

        double inputInt = Double.parseDouble(input);
        double percDouble = Double.parseDouble(percentage);
        double total = inputInt + ((percDouble / 100) * percDouble);

        //total
        if(type.equals(Constants.PERCENTAGE)){
            tvTotalValue.setText(String.valueOf(total));
        }else {
            total = inputInt +  percDouble;
            tvTotalValue.setText(String.valueOf(total));
        }

        //dividend
        int intDividend = Integer.parseInt(dividend);
        tvPreValue.setText(String.valueOf(total / intDividend));

    }
}
