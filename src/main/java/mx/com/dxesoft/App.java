package mx.com.dxesoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int[] a = {1,2,3,4,5,6,2,3,7,8};


    }


    public static void nodups(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        Set<Integer> noDups = new HashSet<>();

        for (int number :
                numbers) {
            if (noDups.contains(number)) {
                System.out.println(number);
            } else {
                noDups.add(number);
            }
        }
    }
}
