package com.piq2015.piQ.highscore;

import com.piq2015.piQ.util.SharedPreferenceWrapper;

import java.util.Arrays;

/**
 * Created by aliasapps on 15-03-21.
 */
public class HighScore {
    private static final String TAG = "HighScore";

    public static void saveScore(int score) {
        SharedPreferenceWrapper.writeString(score);
    }

    public static String readScores() {
        return SharedPreferenceWrapper.readString();
    }

    public static String[] topTen() {
        String[] topTen = new String[10];
        String allScores = readScores();
        if (allScores.equalsIgnoreCase("not found"))
            return new String[]{"0"};
        String[] allScoresArr = allScores.split(",");

        int[] allScoresArrInt = new int[allScoresArr.length];
        int numberOfScoreToShow = allScoresArrInt.length < 10 ? allScoresArrInt.length : 10;
        for (int i = 0; i < allScoresArr.length; i++)
            allScoresArrInt[i] = Integer.parseInt(allScoresArr[i]);

        Arrays.sort(allScoresArrInt);

        for (int i = allScoresArrInt.length - 1; i >= allScoresArrInt.length - numberOfScoreToShow; i--) {
            int index = allScoresArr.length - i - 1;
            topTen[index] = "" + allScoresArrInt[i];
        }
        return topTen;
    }
}
