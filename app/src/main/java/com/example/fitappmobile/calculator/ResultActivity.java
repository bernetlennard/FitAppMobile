package com.example.fitappmobile.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappmobile.R;
import com.example.fitappmobile.rating.DetailActivity;
import com.example.fitappmobile.util.BMI;
import com.example.fitappmobile.util.MenuImpl;

public class ResultActivity extends MenuImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult = findViewById(R.id.textViewResult);
        TextView textViewCategory = findViewById(R.id.textViewCategory);
        Button buttonDetails = findViewById(R.id.buttonDetails);

        double weight = getIntent().getDoubleExtra("WEIGHT", 0);
        double height = getIntent().getDoubleExtra("HEIGHT", 0);

        double bmiValue = BMI.calculate(weight, height);
        textViewResult.setText(String.format("Dein BMI: %.2f", bmiValue));

        String category = BMI.getCategory(bmiValue);
        textViewCategory.setText(category);

        buttonDetails.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, DetailActivity.class);
            intent.putExtra("legend-category", category);
            startActivity(intent);
        });
    }

}
