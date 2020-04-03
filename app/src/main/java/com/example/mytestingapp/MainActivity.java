package com.example.mytestingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    double percentage= 0.0;
    double dividend = 0.0;

    @BindView(R.id.etInput1)
    EditText input1;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.radioButton1)
    RadioButton rBtnPercentage;
    @BindView(R.id.radioButton2)
    RadioButton rBtnCustom_value;
    @BindView(R.id.btnCalc)
    Button btnCalc;
    @BindView(R.id.flatBtn1_remove)
    FloatingActionButton flatBtn1_remove;
    @BindView(R.id.flatBtn1_add)
    FloatingActionButton flatBtn1_add;
    @BindView(R.id.flatBtn2_remove)
    FloatingActionButton flatBtn2_remove;
    @BindView(R.id.flatBtn2_add)
    FloatingActionButton flatBtn2_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Intent intent = new Intent(this,ViewResultActivity.class);
        startActivity(intent);
        finish();
    }

                //String content = input1.getText().toString();
                //validRadioButton();
                //validFloatingButton();


    }

//    void validRadioButton(){
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch(checkedId){
//                    case R.id.radioButton1:
//                        rBtnPercentage.getText();
//                        break;
//                    case R.id.radioButton2:
//                        rBtnCustom_value.getText();
//                        break;
//                }
//            }
//        });
//    }
//    void validFloatingButton(){
//        flatBtn1_remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                percentage++;
//            }
//        });
//        flatBtn1_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                percentage--;
//            }
//        });
//        flatBtn2_remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              dividend--;
//            }
//        });
//        flatBtn2_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dividend++;
//            }
//        });
//    }

