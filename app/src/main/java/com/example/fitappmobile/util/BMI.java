package com.example.fitappmobile.util;

import com.example.fitappmobile.R;

public class BMI {

    public static final int UNTERGEWICHTIG = R.string.cat_underweight;
    public static final int NORMALGEWICHTIG = R.string.cat_normal;
    public static final int UEBERGEWICHTIG = R.string.cat_overweight;
    public static final int FETTLEIBIG = R.string.cat_obese;

    public static int[] legendValues = new int[]{
            UNTERGEWICHTIG, NORMALGEWICHTIG, UEBERGEWICHTIG, FETTLEIBIG
    };

    public static class Detail {
        public int specResId;
        public String min;
        public String max;

        public Detail(int specResId, String min, String max) {
            this.specResId = specResId;
            this.min = min;
            this.max = max;
        }
    }

    public static Detail[] UNTERGEWICHTIG_DETAILS = {
            new Detail(R.string.spec_very_severe, "", "15.0"),
            new Detail(R.string.spec_severe, "15.0", "16.0"),
            new Detail(R.string.spec_moderate, "16.0", "17.0"),
            new Detail(R.string.spec_mild, "17.0", "18.5")
    };

    public static Detail[] NORMALGEWICHTIG_DETAILS = {
            new Detail(0, "18.5", "25.0")
    };

    public static Detail[] UEBERGEWICHTIG_DETAILS = {
            new Detail(0, "25.0", "30.0")
    };

    public static Detail[] FETTLEIBIG_DETAILS = {
            new Detail(R.string.spec_obese_i, "30.0", "35.0"),
            new Detail(R.string.spec_obese_ii, "35.0", "40.0"),
            new Detail(R.string.spec_obese_iii, "40.0", "")
    };

    // Statische Methode zur Berechnung des BMI: Gewicht / (Grösse in m * Grösse in m)
    public static double calculate(double weightKg, double heightCm) {
        if (heightCm <= 0) return 0;
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    // Hilfsmethode zur Interpretation des Wertes (optional)
    public static int getCategory(double bmi) {
        if (bmi < 18.5) return UNTERGEWICHTIG;
        if (bmi < 25) return NORMALGEWICHTIG;
        if (bmi < 30) return UEBERGEWICHTIG;
        return FETTLEIBIG;
    }
}
