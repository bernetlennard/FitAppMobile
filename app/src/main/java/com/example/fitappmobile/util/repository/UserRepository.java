package com.example.fitappmobile.util.repository;

import android.content.ContentValues;
import java.util.List;
import com.example.fitappmobile.util.DatabaseConnection;

public class UserRepository {
    private static final String TABLE_NAME = "app_user";
    private final DatabaseConnection dbConnection;

    public UserRepository(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public long insertUser(String username, String firstname, String lastname, String password) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("firstname", firstname);
        values.put("lastname", lastname);
        values.put("password", password);
        return dbConnection.insert(TABLE_NAME, values);
    }

    public List<String> selectAllUsers() {
        return dbConnection.selectAll(TABLE_NAME, "username");
    }

    public String selectUser(int id) {
        return dbConnection.select(TABLE_NAME, id, "username");
    }

    public int updateUser(int id, String username, String firstname, String lastname, String password) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("firstname", firstname);
        values.put("lastname", lastname);
        values.put("password", password);
        return dbConnection.update(TABLE_NAME, values, id);
    }

    public int deleteUser(int id) {
        return dbConnection.delete(TABLE_NAME, id);
    }
}
