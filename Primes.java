import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Primes {
    private static final int LIMIT = 15 * 1000 * 1000 + 100000 * 5;
    private static final int MAX_NUMBER = 20000000;

    public static IntStream stream() {
        return IntStream.range(2, LIMIT)
                .parallel()
                .filter(Primes::isPrime);
    }

    private static boolean isPrime(int num) {
        if (num > 2 && num % 2 == 0) {
            return false;
        }
        int top = (int) Math.sqrt(num) + 1;
        for (int i = 3; i < top; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}


