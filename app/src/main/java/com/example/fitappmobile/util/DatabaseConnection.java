package com.example.fitappmobile.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * Core class for database connection and generic CRUD operations.
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private final DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    private DatabaseConnection(Context context) {
        databaseHelper = new DatabaseHelper(context.getApplicationContext());
    }

    public static synchronized DatabaseConnection getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseConnection(context);
        }
        return instance;
    }

    private synchronized SQLiteDatabase getDatabase() {
        if (database == null || !database.isOpen()) {
            database = databaseHelper.getWritableDatabase();
        }
        return database;
    }

    public long insert(String table, ContentValues values) {
        return getDatabase().insert(table, null, values);
    }

    public List<String> selectAll(String table, String column) {
        List<String> list = new ArrayList<>();
        Cursor cursor = getDatabase().query(table, new String[]{column}, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                list.add(cursor.getString(0));
            }
            cursor.close();
        }
        return list;
    }

    public String select(String table, int id, String column) {
        String result = null;
        Cursor cursor = getDatabase().query(table, new String[]{column}, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                result = cursor.getString(0);
            }
            cursor.close();
        }
        return result;
    }

    public int update(String table, ContentValues values, int id) {
        return getDatabase().update(table, values, "id = ?", new String[]{String.valueOf(id)});
    }

    public int delete(String table, int id) {
        return getDatabase().delete(table, "id = ?", new String[]{String.valueOf(id)});
    }

    public void close() {
        databaseHelper.close();
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "data.db";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onConfigure(SQLiteDatabase db) {
            super.onConfigure(db);
            db.setForeignKeyConstraintsEnabled(true);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            // --- APP_USER ---
            database.execSQL("CREATE TABLE IF NOT EXISTS app_user (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "firstname TEXT, " +
                    "lastname TEXT, " +
                    "username TEXT UNIQUE, " +
                    "password TEXT);");

            database.execSQL("CREATE INDEX IF NOT EXISTS idx_app_user_username ON app_user (username);");

            // --- MEASUREMENT ---
            database.execSQL("CREATE TABLE IF NOT EXISTS measurement (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "date TIMESTAMP, " +
                    "user_id INTEGER, " +
                    "height INTEGER, " +
                    "weight INTEGER, " +
                    "bmi REAL, " +
                    "FOREIGN KEY (user_id) REFERENCES app_user (id) ON DELETE CASCADE);");

            database.execSQL("CREATE INDEX IF NOT EXISTS idx_measurement_date ON measurement (date);");
            database.execSQL("CREATE INDEX IF NOT EXISTS idx_measurement_user_id ON measurement (user_id);");
            database.execSQL("CREATE INDEX IF NOT EXISTS idx_measurement_user_id_date ON measurement (user_id, date DESC);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
            // Löscht die Tabellen in umgekehrter Reihenfolge (wegen der Foreign Keys)
            database.execSQL("DROP TABLE IF EXISTS measurement;");
            database.execSQL("DROP TABLE IF EXISTS app_user;");

            onCreate(database);
        }
    }
}
