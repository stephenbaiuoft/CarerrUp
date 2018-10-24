package Microsoft;

/**
 *
 * Implement atoi to convert a testing.string to an integer.
 * Think about all corner cases
 * 1. invalid characters
 * 2. white spaces
 * 3. overflow
 * 4. sign
 */

public class L8_atoi_M {
    public int myAtoi(String str) {

        // case: float? or other spaces?
        // case: sign? parsing? -?
        // case: white space? trim out
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();

        int sign = 1;
        int start = 0;
        if (str.charAt(start) == '-') {
            sign = -1;
            start ++;
        } else if (str.charAt(start) == '+') {
            start ++;
        }

        char tmp = ' ';
        long sum = 0;
        for (int i = start; i < str.length(); i++) {
            tmp = str.charAt(i);
            if (!Character.isDigit(tmp)) {
                return (int) sum * sign;
            }
            // offset in java
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            else if (sign == -1 && -1 * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

        }

        return (int) sum*sign;
    }


}
