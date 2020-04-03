package com.example.mytestingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etPercentage, etDividends, etInput1;
    private FloatingActionButton fabIncreasePercentage, fabDecreasePercentage, fabIncreaseDividend, fabDecreaseDividend;
    private Button btnCalc;
    private RadioGroup radioGroup;
    private static final double DEFAULT_PERCENTAGE = 1.0;
    private static final int DEFAULT_DIVIDEND = 1;

    private static final int PERCENTAGE_TYPE = 1;
    private static final int DIVIDEND_TYPE = 2;
    private String type = Constants.PERCENTAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        validRadioButton();
        validateCalcButton();

    }

    private void initialize() {
        etInput1 = findViewById(R.id.etInput1);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalc = findViewById(R.id.btnCalc);
        etPercentage = findViewById(R.id.etPercentage);
        etDividends = findViewById(R.id.etDividends);
        fabIncreasePercentage = findViewById(R.id.flatBtnIncreasePercentage);
        fabDecreasePercentage = findViewById(R.id.flatBtnDecreasePercentage);
        fabIncreaseDividend = findViewById(R.id.flatBtnIncreaseDividend);
        fabDecreaseDividend = findViewById(R.id.flatBtnDecreaseDividend);

        etPercentage.setText(String.valueOf(DEFAULT_PERCENTAGE - 1));
        etDividends.setText(String.valueOf(DEFAULT_DIVIDEND));

        fabIncreasePercentage.setOnClickListener(this);
        fabDecreasePercentage.setOnClickListener(this);
        fabIncreaseDividend.setOnClickListener(this);
        fabDecreaseDividend.setOnClickListener(this);
        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.flatBtnIncreasePercentage:
                increase(etPercentage, PERCENTAGE_TYPE);
                break;
            case R.id.flatBtnIncreaseDividend:
                increase(etDividends, DIVIDEND_TYPE);
                break;
            case R.id.flatBtnDecreasePercentage:
                if (Double.parseDouble(etPercentage.getText().toString()) > 0.0)
                    decrease(etPercentage, PERCENTAGE_TYPE);
                break;
            case R.id.flatBtnDecreaseDividend:
                decrease(etDividends, DIVIDEND_TYPE);
                break;
            case R.id.btnCalc:
                calculateResult();
        }
    }

    private void increase(EditText editText, int type) {
        String inputString = editText.getText().toString();
        if (type == 1) {
            try {
                double inputDouble = Double.parseDouble(inputString);
                editText.setText(String.valueOf(inputDouble + DEFAULT_PERCENTAGE));
            } catch (Exception e) {
                Toast.makeText(this, "Percentage must be double value", Toast.LENGTH_SHORT).show();
            }

        } else {
            try {
                int inputInt = Integer.parseInt(inputString);
                editText.setText(String.valueOf(inputInt + DEFAULT_DIVIDEND));
            } catch (Exception e) {
                Toast.makeText(this, "Dividend must be integer value", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void decrease(EditText editText, int type) {
        String inputString = editText.getText().toString();
        if (type == 1) {
            try {
                if (Double.parseDouble(etPercentage.getText().toString()) > 0.0) {
                    double inputDouble = Double.parseDouble(inputString);
                    editText.setText(String.valueOf(inputDouble - DEFAULT_PERCENTAGE));
                }
            } catch (Exception e) {
                Toast.makeText(this, "Percentage must be double value", Toast.LENGTH_SHORT).show();
            }

        } else {
            try {
                if (Integer.parseInt(etDividends.getText().toString()) > 1) {
                    int inputInt = Integer.parseInt(inputString);
                    editText.setText(String.valueOf(inputInt - DEFAULT_DIVIDEND));
                }
            } catch (Exception e) {
                Toast.makeText(this, "Dividend must be integer value", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void validRadioButton() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        type = Constants.PERCENTAGE;
                        break;
                    case R.id.radioButton2:
                        type = Constants.CUSTOM;
                        break;
                }
                Toast.makeText(MainActivity.this, "Set as " + type, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void validateCalcButton() {
        etInput1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    btnCalc.setEnabled(true);
                } else {
                    btnCalc.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void calculateResult() {
        if (isEditTextEmpty(etPercentage) || isEditTextEmpty(etDividends)) {
            return;
        }

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, ViewResultActivity.class);

        bundle.putString(Constants.INPUT, etInput1.getText().toString());
        bundle.putString(Constants.TYPE, type);
        bundle.putString(Constants.PERCENTAGE, etPercentage.getText().toString());
        bundle.putString(Constants.DIVIDEND, etDividends.getText().toString());

        intent.putExtras(bundle);
        startActivity(intent);
    }

    private boolean isEditTextEmpty(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Missing values!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

}

