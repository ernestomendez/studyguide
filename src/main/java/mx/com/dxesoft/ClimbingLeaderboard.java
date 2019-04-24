package mx.com.dxesoft;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem#!
 *
 * Input example
 * 7
 * 100 100 50 40 40 20 10
 * 4
 * 5 25 50 120
 *
 * Sample Output 1
 *
 * 6
 * 4
 * 2
 * 1
 *
 * Input example 2
 * 6
 * 100 90 90 80 75 60
 * 5
 * 50 65 77 90 102
 *
 * Sample Output 2
 *
 * 6
 * 5
 * 4
 * 2
 * 1
 */
public class ClimbingLeaderboard {
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

            int[] rank = initialScore(scores);

            int[] aliceRank = new int[alice.length];

            for (int i = 0; i < alice.length; i++) {
                int scorePosition = getScorePosition(scores, alice[i], 0, scores.length - 1);

                if (alice[i] == scores[scorePosition]) {
                    aliceRank[i] = rank[scorePosition];
                } else if (alice[i] > scores[scorePosition]) {
                    aliceRank[i] = rank[scorePosition];
                } else {
                    aliceRank[i] = rank[scorePosition] + 1;
                }
            }
            return aliceRank;
    }

    public static void main(String[] args) throws IOException {
        int scores[] = {100, 90, 90, 80, 75, 60};

        int alice[] = {50, 65, 77, 90, 102};

        final int[] ints = climbingLeaderboard(scores, alice);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    static int[] initialScore(int[] scores) {
        int[] rank = new int[scores.length];

        int actualRank = 1;

        rank[0] = actualRank;
        for (int i = 1; i < scores.length; i++) {
            if(scores[i -1] == scores[i]) {
                rank[i] = rank[i -1];
            } else {
                rank[i] = rank[i-1] + 1;
            }
        }

        return rank;
    }

    static int getScorePosition(int[] scores, int alice, int origin, int end) {
        int n = end - origin;

        int response;
        if (n < 2) {
            if (scores[end] > alice)
                return end;
            else
                return origin;
        }

        int mid = n / 2;

        int midPos = origin + mid;

        if (scores[midPos] == alice) {
            return midPos;
        } else if (scores[midPos] > alice) {
            response = getScorePosition(scores, alice, midPos + 1, end);
        } else {
            response = getScorePosition(scores, alice, origin, midPos);
        }

        return response;
    }
}
