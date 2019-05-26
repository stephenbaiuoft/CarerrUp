package Codebase.DP;

/*
*
A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character *, which can be treated as one of the numbers from 1 to 9.
Given the encoded message containing digits and the character *, return the total number of ways to decode it.
Also, since the answer may be very large, you should return the output mod 10^9 + 7.


* */

public class L676_DecodeWaysII {
    public L676_DecodeWaysII() {
        String s = "**";
        int c = numDecodings(s);
        System.out.println(c);
    }

    private int cnt1(char c) {
        if (c == '0') {
            return 0; // previously one does not have any choice
        }

        if (c != '*') {
            return 1; // you have 1 choice
        }
        // * so you have 1~9 # of choices
        return 9;
    }

    // # of combinations to be multiplied
    private int cnt2(char c2, char c1) {
        if (c2 == '0') {
            return 0; // no choice
        }

        if (c2 == '1') {
            if (c1 == '*') {
                return 9;
            }

            return 1; // c1 is some valid number
        }

        if (c2 == '2') {
            if (c1 == '*') {
                return 6; // max # of choices for c1
            }

            if (c1 <= '6') {
                return 1; // 1 valid number
            }

            return 0;   //c1 7~9 or 0 --> no multiplication possible
        }

        if (c2 >= '3' && c2 <= '9') {
            return 0;
        }

        // c2 == *
        if (c1 >= '0' && c1 <= '6') {
            return 2; // 2 valid choices [1,2]
        }

        if (c1 >= '7' && c1 <= '9') {
            return 1; // only 1 which is 1
        }

        // c2,c1  ==> 2 digit combinations :
        //
        // c2 = 1, for 11~19
        // c2 = 2, for 21~26
        return 15;
    }

    public int numDecodings(String s) {
        // write your code here
        char[] charSet = s.toCharArray();
        long MOD = 1000000007;

        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i - 1] * cnt1(charSet[i - 1]);
            if (i > 1) {
                dp[i] += dp[i - 2] * cnt2(charSet[i - 2], charSet[i - 1]);
            }

            dp[i] %= MOD;
        }

        return (int)dp[s.length()];
    }
}
