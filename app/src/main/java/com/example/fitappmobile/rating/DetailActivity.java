package com.example.fitappmobile.rating;

import static com.example.fitappmobile.util.BMI.FETTLEIBIG;
import static com.example.fitappmobile.util.BMI.NORMALGEWICHTIG;
import static com.example.fitappmobile.util.BMI.UEBERGEWICHTIG;
import static com.example.fitappmobile.util.BMI.UNTERGEWICHTIG;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitappmobile.R;
import com.example.fitappmobile.util.MenuImpl;

public class DetailActivity extends MenuImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView textViewDetail = findViewById(R.id.textViewDetail);
        String legendCategory = getIntent().getStringExtra("legend-category");
        if (legendCategory != null) {
            if (legendCategory.equals(UNTERGEWICHTIG)) {
                textViewDetail.setText(legendCategory);
            } else if (legendCategory.equals(NORMALGEWICHTIG)) {
                textViewDetail.setText(legendCategory);
            } else if (legendCategory.equals(UEBERGEWICHTIG)) {
                textViewDetail.setText(legendCategory);
            } else if (legendCategory.equals(FETTLEIBIG)) {
                textViewDetail.setText(legendCategory);
            }
        } else {
            textViewDetail.setText("Fehler");
        }
    }
}
