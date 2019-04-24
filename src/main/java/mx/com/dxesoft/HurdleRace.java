package mx.com.dxesoft;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/the-hurdle-race/problem?h_r=next-challenge&h_v=zen
 */
public class HurdleRace {

    static int hurdleRace(int k, int[] height) {
        int potion = 0;
        if (null != height && height.length >= 1) {
            try (IntStream heights = Arrays.stream(height)) {
                final OptionalInt max = heights.max();

                potion = max.getAsInt() - k;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return potion < 0? 0: potion;
    }

    public static void main(String args[]) {

        //int[] height = {1, 6, 3, 5, 2};
//        int[] height = {2, 5, 4, 5, 2};
        int[] height = {};

        int k = 7;

        System.out.println(hurdleRace(k, height));
    }
}
