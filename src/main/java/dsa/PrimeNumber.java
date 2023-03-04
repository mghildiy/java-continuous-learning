package dsa;

import org.apache.commons.math3.primes.Primes;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {
        Predicate<Integer> p = PrimeNumber::isPrime;
        IntStream.rangeClosed(1, 100)
                .forEach(i -> {
                    validation(i, p);
                } );
    }

    private static void validation(int n, Predicate<Integer> p) {
        System.out.println("Checking primeness for:"+ n);

        try {
            assert p.test(n) == Primes.isPrime(n);
        } catch (AssertionError e) {
            System.out.println("Test failed for:"+ n);
            throw e;
        }
    }

    private static boolean isPrime(int n) {
        // 1 is not a prime number
        if(n == 1) return false;

        double checkUpto = Math.sqrt(n);

        // if its a perfect square, then it is not a prime
        if(checkUpto % 1 == 0) return false;

        for(int i = 2; i <= checkUpto; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
