package numerical.isPrime;

import java.util.stream.IntStream;

public class IsPrime {
    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        return IntStream.rangeClosed(1, (int) Math.sqrt(number))
                .filter(i -> number % i == 0)
                .count() == 1;
    }

}