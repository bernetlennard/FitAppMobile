package com.example.fitappmobile.util;

import android.content.Intent;
import android.media.Rating;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitappmobile.MainActivity;
import com.example.fitappmobile.R;
import com.example.fitappmobile.calculator.EntryActivity;
import com.example.fitappmobile.config.SettingsActivity;
import com.example.fitappmobile.history.OverviewActivity;
import com.example.fitappmobile.rating.LegendActivity;

public class MenuImpl extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_general, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.HomeActivity) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (menuItem.getItemId() == R.id.CalculatorActivity) {
            startActivity(new Intent(this, EntryActivity.class));
        } else if (menuItem.getItemId() == R.id.RatingActivity) {
            startActivity(new Intent(this, LegendActivity.class));
        } else if (menuItem.getItemId() == R.id.HistoryActivity) {
            startActivity(new Intent(this, OverviewActivity.class));
        } else if (menuItem.getItemId() == R.id.SettingsActivity) {
            startActivity(new Intent(this, SettingsActivity.class));
        } else {
            super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

}
