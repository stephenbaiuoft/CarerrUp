package ByMonth.august.May;

import java.util.Stack;

public class L227_CalculatorIII_M {
    public L227_CalculatorIII_M() {
        String s = "3+5/2";
        int rez = calculate(s);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        //get rid of white space
        s = s.replace(" ", "");
        // use 3 variables to store previous operation
        int prev = 0;
        int num = 0;
        int rez = 0;
        char sign = '+';
        char[] ary = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(ary[i])) {
                num = num* 10 + ary[i] - '0';
            }
            // 2 if statements to take care of the last i case
            if ((i == s.length()-1) || !Character.isDigit(ary[i]) ){
                // handle previous sign
                if (sign == '+') {
                    prev = num;
                }
                else if (sign == '-') {
                    prev = -num;
                }
                else if (sign == '*') {
                    // get rid of the prev effect
                    rez -= prev;
                    prev *= num;
                }
                else if (sign == '/') {
                    rez -= prev;
                    prev /= num;
                }

                rez += prev;
                // assign sign
                sign = ary[i];
                // reset num
                num = 0;
            }

        }
        return rez;
    }
}
