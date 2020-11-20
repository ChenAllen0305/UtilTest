package Test;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<Long> test = Optional.of(1L);
        if (test.isPresent()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
