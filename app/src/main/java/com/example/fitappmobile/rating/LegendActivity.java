package com.example.fitappmobile.rating;

import static com.example.fitappmobile.util.BMI.legendValues;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fitappmobile.MainActivity;
import com.example.fitappmobile.R;
import com.example.fitappmobile.calculator.EntryActivity;
import com.example.fitappmobile.util.MenuImpl;

public class LegendActivity extends MenuImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legend);

        ListView legendList = findViewById(R.id.listViewLegend);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, legendValues);
        legendList.setAdapter(adapter);
        legendList.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(LegendActivity.this, DetailActivity.class);
            intent.putExtra("legend-category", legendValues[i]);
            startActivity(intent);
        });

    }
}