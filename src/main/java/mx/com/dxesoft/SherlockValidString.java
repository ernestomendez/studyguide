package mx.com.dxesoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 *
 * Sample Input 0

 aabbcd

 Sample Output 0

 NO

 Sample Input 1

 aabbccddeefghi

 Sample Output 1

 NO


 */
public class SherlockValidString {

    public static void main(String[] args) {
//        String s = "aabbccddeefghi";  //no
//        String s = "aabbccddeefff";   //yes
//        String s = "aabbccddeefffg";
//        String s = "ab";
//        String s = "";
//        String s = "aabbccddeeffgg";
//        String s = "abcdefghhgfedecba";
//        String s = "abcdefghhgfedecbazzz";
//        String s = "abcdefghhgfdecbazy";
//        String s = "aaaaab";
//        String s = "aaaaacb";
        String s = "aaaacccccggggg";

        System.out.println(isValid(s));
    }

    static String isValid(String s) {

        if (s.equals("")) {
            return "NO";
        }

        if (s.length() == 1 || s.length() == 2) {
            return "YES";
        }

        String value = "NO";

        final Map<String, Long> charFrecuency = calculateFrecuencyArraysStream(s);

        final Map<Long, Integer> frecuencyOfFrecuency = calculateFrecuencyOfFrecuency(charFrecuency);

        if (frecuencyOfFrecuency.size() == 1) {
            value = "YES";
        } else if (frecuencyOfFrecuency.size() == 2) {
            int max = 0;
            int min = 0;
            boolean singleEntry = false;
            boolean needsSubstract = true;
            for (Map.Entry<Long, Integer> entry : frecuencyOfFrecuency.entrySet()) {

                int tmp = entry.getKey().intValue();
                if (tmp > max) {
                    min = max;
                    max = tmp;
                } else {
                    min = tmp;
                }

                if (entry.getValue() == 1) {
                    singleEntry = true;
                    if (entry.getKey() == 1) {
                        needsSubstract = false;
                    }
                }
            }

            if (singleEntry) {
                if (needsSubstract) {
                    if (max - min == 1) {
                        value = "YES";
                    }
                } else {
                    value = "YES";
                }
            }
        }

        return value;
    }

    private static Map<String, Long> calculateFrecuencyArraysStream(String s) {
        final Map<String, Long> collect = Arrays.stream(s.toLowerCase().split(""))
                .collect(
                        groupingBy(
                                c -> c, counting()
                        )
                );
        return collect;
    }

    private static void calculateFrecuencyMapMerge(String s) {
        final Map<Character, Integer> frecuency = new HashMap<>(s.length());

        int max = 0;

        for (char c : s.toCharArray()) {
            final Integer merge = frecuency.merge(c,
                    1,
                    Integer::sum);
            if (merge > max) {
                max = merge;
            }
        }

        System.out.println(frecuency);
    }

    private static void calculateFrecuencyStreamCollect(String s) {

        final Map<Character, Integer> frecuency = s.chars().boxed()
                .collect(toMap(
                        k -> Character.valueOf((char) k.intValue()),
                        v -> 1,
                        Integer::sum)
                );
        System.out.println(frecuency);
    }

    private static Map<Long, Integer> calculateFrecuencyOfFrecuency(Map<String, Long> letters) {
        final Map<Long, Integer> frecuencies = new HashMap<>();

        letters.forEach((k,v) -> {
            frecuencies.merge(v,
                    1,
                    Integer::sum
            );
        });

        return frecuencies;
    }
}
