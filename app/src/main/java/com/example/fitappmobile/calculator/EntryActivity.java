package com.example.fitappmobile.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappmobile.R;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        EditText editWeight = findViewById(R.id.editWeight);
        EditText editHeight = findViewById(R.id.editHeight);
        Button buttonCalculate = findViewById(R.id.button);

        buttonCalculate.setOnClickListener(v -> {
            String weightStr = editWeight.getText().toString();
            String heightStr = editHeight.getText().toString();

            if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                double weight = Double.parseDouble(weightStr);
                double height = Double.parseDouble(heightStr);

                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("WEIGHT", weight);
                intent.putExtra("HEIGHT", height);
                startActivity(intent);
            }
        });
    }
}
