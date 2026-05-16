package com.example.fitappmobile.rating;

import static com.example.fitappmobile.util.BMI.legendValues;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fitappmobile.R;
import com.example.fitappmobile.util.MenuImpl;

import java.util.ArrayList;
import java.util.List;

public class LegendActivity extends MenuImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legend);

        ListView legendList = findViewById(R.id.listViewLegend);

        List<String> translatedValues = new ArrayList<>();
        for (int resId : legendValues) {
            translatedValues.add(getString(resId));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, translatedValues);
        legendList.setAdapter(adapter);
        legendList.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(LegendActivity.this, DetailActivity.class);
            intent.putExtra("legend-category-res", legendValues[i]);
            startActivity(intent);
        });

    }
}
