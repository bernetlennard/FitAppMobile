package com.example.fitappmobile.config;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappmobile.R;
import com.example.fitappmobile.util.MenuImpl;

public class SettingsActivity extends MenuImpl {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btnToUsers = findViewById(R.id.btn_to_users);
        btnToUsers.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsActivity.this, UsersActivity.class);
            startActivity(intent);
        });
    }
}