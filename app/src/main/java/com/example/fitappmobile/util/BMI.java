package com.example.fitappmobile.util;

public class BMI {

    public static String UNTERGEWICHTIG = "Untergewichtig";
    public static String NORMALGEWICHTIG = "Normalgewichtig";
    public static String UEBERGEWICHTIG = "Übergewichtig";
    public static String FETTLEIBIG = "Fettleibig";

    public static String[] legendValues = new String[]{
            UNTERGEWICHTIG, NORMALGEWICHTIG, UEBERGEWICHTIG, FETTLEIBIG
    };

    // Statische Methode zur Berechnung des BMI: Gewicht / (Grösse in m * Grösse in m)
    public static double calculate(double weightKg, double heightCm) {
        if (heightCm <= 0) return 0;
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    // Hilfsmethode zur Interpretation des Wertes (optional)
    public static String getCategory(double bmi) {
        if (bmi < 18.5) return "Untergewicht";
        if (bmi < 25) return "Normalgewicht";
        if (bmi < 30) return "Übergewicht";
        return "Sehr Fett";
    }
}