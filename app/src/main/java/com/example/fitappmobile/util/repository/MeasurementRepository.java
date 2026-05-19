package com.example.fitappmobile.util.repository;

import android.content.ContentValues;
import java.util.List;
import com.example.fitappmobile.util.DatabaseConnection;

public class MeasurementRepository {
    private static final String TABLE_NAME = "measurement";
    private final DatabaseConnection dbConnection;

    public MeasurementRepository(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public long insertMeasurement(String date, int userId, int height, int weight, double bmi) {
        ContentValues values = new ContentValues();
        values.put("date", date);
        values.put("user_id", userId);
        values.put("height", height);
        values.put("weight", weight);
        values.put("bmi", bmi);
        return dbConnection.insert(TABLE_NAME, values);
    }

    public List<String> selectAllMeasurements(String column) {
        return dbConnection.selectAll(TABLE_NAME, column);
    }

    public String selectMeasurement(int id, String column) {
        return dbConnection.select(TABLE_NAME, id, column);
    }

    public int updateMeasurement(int id, String date, int userId, int height, int weight, double bmi) {
        ContentValues values = new ContentValues();
        values.put("date", date);
        values.put("user_id", userId);
        values.put("height", height);
        values.put("weight", weight);
        values.put("bmi", bmi);
        return dbConnection.update(TABLE_NAME, values, id);
    }

    public int deleteMeasurement(int id) {
        return dbConnection.delete(TABLE_NAME, id);
    }
}
