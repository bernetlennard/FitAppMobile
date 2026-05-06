package com.example.fitappmobile.rating;

import static com.example.fitappmobile.util.BMI.FETTLEIBIG;
import static com.example.fitappmobile.util.BMI.NORMALGEWICHTIG;
import static com.example.fitappmobile.util.BMI.UEBERGEWICHTIG;
import static com.example.fitappmobile.util.BMI.UNTERGEWICHTIG;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.fitappmobile.R;
import com.example.fitappmobile.util.BMI;
import com.example.fitappmobile.util.MenuImpl;

public class DetailActivity extends MenuImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textViewTitle = findViewById(R.id.textViewDetailTitle);
        TableLayout tableLayout = findViewById(R.id.tableLayoutDetails);

        String legendCategory = getIntent().getStringExtra("legend-category");
        if (legendCategory != null) {
            textViewTitle.setText(legendCategory);
            
            String[][] details = null;
            if (legendCategory.equals(UNTERGEWICHTIG)) {
                details = BMI.UNTERGEWICHTIG_DETAILS;
            } else if (legendCategory.equals(NORMALGEWICHTIG)) {
                details = BMI.NORMALGEWICHTIG_DETAILS;
            } else if (legendCategory.equals(UEBERGEWICHTIG)) {
                details = BMI.UEBERGEWICHTIG_DETAILS;
            } else if (legendCategory.equals(FETTLEIBIG)) {
                details = BMI.FETTLEIBIG_DETAILS;
            }

            if (details != null) {
                populateTable(tableLayout, details);
            }
        } else {
            textViewTitle.setText("Fehler");
        }
    }

    private void populateTable(TableLayout tableLayout, String[][] details) {
        for (String[] rowData : details) {
            TableRow row = new TableRow(this);
            row.setPadding(0, 16, 0, 16);

            // Spezifisch
            TextView spec = new TextView(this);
            spec.setText(rowData[0]);
            spec.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            row.addView(spec);

            // Minimal
            TextView min = new TextView(this);
            min.setText(rowData[1]);
            min.setGravity(Gravity.CENTER);
            min.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            row.addView(min);

            // Maximal
            TextView max = new TextView(this);
            String maxValue = rowData[2];
            if (!maxValue.isEmpty()) {
                max.setText("< " + maxValue);
            } else {
                max.setText("");
            }
            max.setGravity(Gravity.CENTER);
            max.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            row.addView(max);

            tableLayout.addView(row);
        }
    }
}
