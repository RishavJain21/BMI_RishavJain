package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {
    EditText weight,height;
    TextView result;
    String Calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        result=findViewById(R.id.result);
    }

    public void calculate_bmi(View view) {
        String s1=weight.getText().toString();
        String s2=height.getText().toString();

        float wv = Float.parseFloat(s1);
        float hv = Float.parseFloat(s2)/100;

        float bmi = wv/(hv*hv);
        String str = String.format("%.02f", bmi);

        if(bmi<=18.5){
            Calculation = "Your BMI is :\n"+str+"\nYou are UNDERWEIGHT.";
        }
        if(bmi>18.5 && bmi<=24.9){
            Calculation = "Your BMI is :\n"+str+"\nYou are NORMAL.";
        }
        if(bmi>24.9 && bmi<=29.9){
            Calculation = "Your BMI is :\n"+str+"\nYou are OVERWEIGHT.";
        }
        if(bmi>29.9){
            Calculation = "Your BMI is :\n"+str+"\nYou are OBESE.";
        }
        result.setText(Calculation);
    }
}