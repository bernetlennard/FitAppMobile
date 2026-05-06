package com.example.fitappmobile.util;

public class BMI {

    public static String UNTERGEWICHTIG = "Untergewichtig";
    public static String NORMALGEWICHTIG = "Normalgewichtig";
    public static String UEBERGEWICHTIG = "Übergewichtig";
    public static String FETTLEIBIG = "Fettleibig";

    public static String[] legendValues = new String[]{
            UNTERGEWICHTIG, NORMALGEWICHTIG, UEBERGEWICHTIG, FETTLEIBIG
    };

    public static String[][] UNTERGEWICHTIG_DETAILS = {
            {"sehr stark", "", "15.0"},
            {"stark", "15.0", "16.0"},
            {"mässig", "16.0", "17.0"},
            {"leicht", "17.0", "18.5"}
    };

    public static String[][] NORMALGEWICHTIG_DETAILS = {
            {"", "18.5", "25.0"}
    };

    public static String[][] UEBERGEWICHTIG_DETAILS = {
            {"", "25.0", "30.0"}
    };

    public static String[][] FETTLEIBIG_DETAILS = {
            {"mässig (Grad I)", "30.0", "35.0"},
            {"stark (Grad II)", "35.0", "40.0"},
            {"sehr stark (Grad III)", "40.0", ""}
    };

    // Statische Methode zur Berechnung des BMI: Gewicht / (Grösse in m * Grösse in m)
    public static double calculate(double weightKg, double heightCm) {
        if (heightCm <= 0) return 0;
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    // Hilfsmethode zur Interpretation des Wertes (optional)
    public static String getCategory(double bmi) {
        if (bmi < 18.5) return UNTERGEWICHTIG;
        if (bmi < 25) return NORMALGEWICHTIG;
        if (bmi < 30) return UEBERGEWICHTIG;
        return FETTLEIBIG;
    }
}