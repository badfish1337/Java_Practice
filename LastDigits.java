import java.math.BigInteger;

public class LastDigits {
    /*
            n is a count.
            Starting with 1, 1*1 = 1 and 1 ends with 1. Increment count by 1.
            2 * 2 = 4. 4 does not end with 2. 3*3 =9. 9 does not end with 3...
            5*5=25, 25 ends with 5, increment count by 1.
            Return the nth number that ends with itself.
            n <= 5000

            BigInteger.valueOf(int)
                      .mod(BigInteger)
                      .multiply(BigInteger)
                      .equals(BigInteger)
     */
    // Initializes squared and i
    private static BigInteger squared = BigInteger.ZERO;

    public static BigInteger get(int n){
        // Initial Test
        if(n > 5000){
            return null;
        }
        if(n == 1){
            return BigInteger.ONE;
        }
        // Stores total matches - will  end loop once countMatches == n
        int countMatches = 1;

        // Increases match count until matches == n
        long i = 2;
        BigInteger j = BigInteger.ZERO;
        while(countMatches < n) {
            if(i % 10 == 5 || i % 10 == 6) {
                j = BigInteger.valueOf(i);
                // Update to current value of i * i

                squared = j.pow(2);

                // Last digit must be 5 or 6 to be a match (except 1) Can this be used to our advantage?

                if (checkDigits(j)) {
                    countMatches++;
                    System.out.println("Match found : " + i + "\ncountMatches = " + countMatches + "\n");
                }
            }
            i++;
        }
        return j;
    }


    //FIXME: Brute force algorithm is not fast enough.
    public static boolean checkDigits(BigInteger i){
        // if i == 0
        if (i.equals(BigInteger.ZERO))
            return true;


        boolean lastDigitIsEqual = squared.mod(BigInteger.TEN).equals(i.mod(BigInteger.TEN));
        // if squared % 10 == i % 10
        if(lastDigitIsEqual){
            // Remove a digit from each until either i == 0 (return true) or last digits do not match (return false)
            squared = squared.divide(BigInteger.TEN);
            i = i.divide(BigInteger.TEN);
            return checkDigits(i); // Recursive call to continue removing digits until either i == 0 or
        }
        return false;
    }

        // FIXME: Instead of counting digits, multiply by 10 to % by and verify numbers are equal?
    //Or, use last digit until one number is empty?
    public static int countDigits(BigInteger currentValue){
        if(currentValue.divide(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))){
            return 1;
        }
        return 1 + countDigits(currentValue.divide(BigInteger.valueOf(10)));
    }
}
