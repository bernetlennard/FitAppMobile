package com.example.fitappmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitappmobile.calculator.EntryActivity;
import com.example.fitappmobile.util.MenuImpl;

public class MainActivity extends MenuImpl {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton = findViewById(R.id.buttonStart);

        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EntryActivity.class);
            startActivity(intent);
        });
    }
}