package numerical.isPrime;

import static numerical.isPrime.IsPrime.isPrime;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestIsPrime {
    @ParameterizedTest(name = "{arguments} is prime")
    @ValueSource(ints = { 2, 3, 5, 7, 17, 101 })
    void test_isPrime(int number) {
        assertTrue(isPrime(number));
    }

    @ParameterizedTest(name = "{arguments} is not prime")
    @ValueSource(ints = { 1, 4, 10, 100, 121, 360_000 })
    void test_isNotPrime(int number) {
        assertTrue(!isPrime(number));
    }
}
