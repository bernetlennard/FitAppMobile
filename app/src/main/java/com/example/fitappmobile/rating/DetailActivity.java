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

        int categoryResId = getIntent().getIntExtra("legend-category-res", 0);
        if (categoryResId != 0) {
            textViewTitle.setText(categoryResId);
            
            BMI.Detail[] details = null;
            if (categoryResId == UNTERGEWICHTIG) {
                details = BMI.UNTERGEWICHTIG_DETAILS;
            } else if (categoryResId == NORMALGEWICHTIG) {
                details = BMI.NORMALGEWICHTIG_DETAILS;
            } else if (categoryResId == UEBERGEWICHTIG) {
                details = BMI.UEBERGEWICHTIG_DETAILS;
            } else if (categoryResId == FETTLEIBIG) {
                details = BMI.FETTLEIBIG_DETAILS;
            }

            if (details != null) {
                populateTable(tableLayout, details);
            }
        } else {
            textViewTitle.setText(R.string.error);
        }
    }

    private void populateTable(TableLayout tableLayout, BMI.Detail[] details) {
        for (BMI.Detail rowData : details) {
            TableRow row = new TableRow(this);
            row.setPadding(0, 16, 0, 16);

            // Spezifisch
            TextView spec = new TextView(this);
            if (rowData.specResId != 0) {
                spec.setText(rowData.specResId);
            } else {
                spec.setText("");
            }
            spec.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            row.addView(spec);

            // Minimal
            TextView min = new TextView(this);
            min.setText(rowData.min);
            min.setGravity(Gravity.CENTER);
            min.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            row.addView(min);

            // Maximal
            TextView max = new TextView(this);
            String maxValue = rowData.max;
            if (!maxValue.isEmpty()) {
                max.setText(getString(R.string.less_than_format, maxValue));
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
