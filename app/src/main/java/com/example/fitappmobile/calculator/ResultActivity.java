package com.example.fitappmobile.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappmobile.R;
import com.example.fitappmobile.util.BMI;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult = findViewById(R.id.textViewResult);

        double weight = getIntent().getDoubleExtra("WEIGHT", 0);
        double height = getIntent().getDoubleExtra("HEIGHT", 0);

        double result = BMI.calculate(weight, height);
        textViewResult.setText(String.format("Dein BMI: %.2f", result));
    }
}
