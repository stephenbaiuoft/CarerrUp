package Leetcode;

public class L227_M {
    public L227_M() {
        String input = "3+2*2";
        int rez = calculate(input);
        System.out.println(rez);
    }

    public int calculate(String s) {
        if (s == null || s.length() < 1) return 0;
        s = s.replace(" ", "");

        // prev value, current val
        int prev = 0, cval = 0, result = 0;
        // default to '+' -> logic to add
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                cval = cval*10 + Character.getNumericValue(c);
            }
            if (i == s.length() - 1 || !Character.isDigit(c)) {
                // now look at previous sign
                if ( sign == '+') {
                    prev = cval;
                }

                else if (sign == '-') {
                    prev = -cval;
                }
                else if (sign == '*') {
                    result -= prev;
                    prev *= cval;

                }
                else {
                    result -= prev;
                    prev /= cval;
                }
                result += prev;
                // assign sign to c again
                sign = c;
                cval = 0;
            }

        }
        return result;


    }
}
