package mx.com.dxesoft;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class RangeStream {

    @Test
    public void range() {

//        this range is non inclusive
        IntStream.range(0, 10)
                .filter(n -> n%2 == 0)
                .forEach(System.out::println);

        System.out.println();

        IntStream.rangeClosed(0, 10)
                .filter(n -> n%2 != 0)
                .forEach(System.out::println);
    }
}
