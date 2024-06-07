package no.acntech.ddd.utils.math;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Modulus 10 computation
 * <p>
 * in a valid N-digit "modulus 10" number, the least significant digit (the rightmost) is a "control digit", computed from the
 * leftmost N-1 digits according to the following rules:
 * <p>
 * each digit is multiplied with a weight. the weights are 2, 1, 2, 1, ...  starting from the LEAST significant digit.
 * <p>
 * the DIGITS in the products are added together (the product 14 contributes 5 to the sum)
 * <p>
 * the sum, modulo 10, is subtracted from 10.
 * <p>
 * the result, modulo 10, is the control digit.
 * <p>
 * Example: compute Z for 3197Z (F(x) computes the sum of the decimal digits of x)
 * <p>
 * sum = F(7*2) + F(9*1) + F(1*2) + F(3*1) = (1 + 4) + 9 + 2 + 3 = 19
 * <p>
 * control digit = (10 - (19 % 10)) % 10 = (10 - 9) % 10 = 1
 *
 * <p>
 * N-digit numbers are represented as either<br>
 * <p>
 * (1) an array of int's, where each element is a single digit, and the first element is the most significant digit int n[] = {3,
 * 1, 9, 7, 1};
 * </p>
 * <p>
 * (2) a String containing numeric characters, the first character is the most significant digit String s = "31971";
 * </p>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Modulus10Utils {


    public static int calculateControlDigit(@NonNull String num) {
        return calculateControlDigit(s2v(num, num.length()), num.length());
    }

    public static int calculateControlDigit(@NonNull String num, int len) {
        return calculateControlDigit(s2v(num, len), len);
    }

    /**
     * Generate the control digit for a given number according to modulus 10
     *
     * @param num the digits we should generate a control digit for, most significant digits first
     * @param len number of leading digits to use,
     * @return the control digit (always in [0, 9])
     */
    public static int calculateControlDigit(int @NonNull [] num, int len) {
        int sum = 0;
        for (int i = len, j = 2; i-- > 0; j = 3 - j) {
            int x = num[i] * j;
            sum += (x < 10 ? x : 1 + x - 10);
        }
        // == (10 - sum % 10) % 10
        return 9 - (sum + 9) % 10;
    }

    public static boolean checkControlDigit(@NonNull String num) {
        return checkControlDigit(s2v(num));
    }

    /**
     * Check if a number is valid according to the modulus 10 algorithm
     *
     * @param num the account number to check
     * @return <code>true</code> if the number is valid
     * <code>false</code> if not
     */
    public static boolean checkControlDigit(int @NonNull [] num) {
        return calculateControlDigit(num, num.length - 1) == num[num.length - 1];
    }

    /**
     * Generate and return a modulus 10 number based on the given number
     *
     * @param base the base number to make mudulus 10 valid
     * @return the resulting modulus 10 number
     */
    public static String appendControlDigit(@NonNull String base) {
        return base + calculateControlDigit(base, base.length());
    }

    public static String appendControlDigit(int[] base) {
        StringBuilder sb = new StringBuilder();
        for (int i : base) {
            sb.append(i);
        }
        return sb.append(calculateControlDigit(base, base.length)).toString();
    }

    private static int[] s2v(@NonNull String s, int len) {
        final int[] v = new int[len];
        final int max = (Math.min(v.length, s.length()));
        for (int i = 0; i < max; i++) {
            v[i] = Character.digit(s.charAt(i), 10);
        }
        return v;
    }

    private static int[] s2v(String s) {
        return s2v(s, s.length());
    }

}

