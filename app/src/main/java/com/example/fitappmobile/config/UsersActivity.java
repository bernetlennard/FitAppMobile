package com.example.fitappmobile.config;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fitappmobile.R;
import com.example.fitappmobile.util.DatabaseConnection;
import com.example.fitappmobile.util.MenuImpl;
import com.example.fitappmobile.util.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsersActivity extends MenuImpl {

    private Spinner spinnerUsers;
    private List<String> userList;
    private ArrayAdapter<String> adapter;
    private SharedPreferences prefs;

    private UserRepository userRepository;
    private static final String PREFS_NAME = "FitAppPrefs";
    private static final String KEY_CURRENT_USER = "currentUser";
    private static final String DEFAULT_USER = "<anonymous>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        DatabaseConnection db = DatabaseConnection.getInstance(this);
        userRepository = new UserRepository(db);

        spinnerUsers = findViewById(R.id.spinner_users);
        Button btnNewUser = findViewById(R.id.btn_new_user);

        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        loadUsers();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, userList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUsers.setAdapter(adapter);

        String currentUser = prefs.getString(KEY_CURRENT_USER, DEFAULT_USER);
        int position = userList.indexOf(currentUser);
        if (position >= 0) {
            spinnerUsers.setSelection(position);
        }

        spinnerUsers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedUser = userList.get(position);
                prefs.edit().putString(KEY_CURRENT_USER, selectedUser).apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnNewUser.setOnClickListener(v -> showNewUserDialog());
    }

    private void loadUsers() {
        userList = userRepository.selectAllUsers();

        if (userList.isEmpty()) {
            userList.add(DEFAULT_USER);
            userRepository.insertUser(DEFAULT_USER, "", "", "");
        }
    }

    private void showNewUserDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.new_login_title);
        builder.setMessage(R.string.enter_username_message);

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton(R.string.add, (dialog, which) -> {
            String newUsername = input.getText().toString().trim();
            if (!newUsername.isEmpty() && !userList.contains(newUsername)) {
                userRepository.insertUser(newUsername, "", "", "");
                userList.add(newUsername);
                adapter.notifyDataSetChanged();

                spinnerUsers.setSelection(userList.size() - 1);
            }
        });

        builder.setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());

        builder.show();
    }
}