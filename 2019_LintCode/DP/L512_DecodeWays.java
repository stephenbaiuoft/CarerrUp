package DP;

/*
*
Description
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

* */
public class L512_DecodeWays {

    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.length() == 0 ) return 0;

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }

        dp[1] = 1; // regardless, the first non-0 character would be 1 way of decoding
        for(int i = 2; i <= s.length(); i++) {
            int tmp = Integer.parseInt(s.substring(i-2, i));

            if (tmp >= 10 && tmp <=26 ) {
                dp[i] += dp[i-2]; // add # of ways for a possible combination of DP[i-2] + 11~26 1 more choice
            }

            if (Integer.parseInt(s.substring(i-1,i)) != 0) {
                dp[i] += dp[i-1]; // DP[i-1] + 1~9 another # of choice
            } else if (tmp > 26) { // the value is ending with 0 && > 26
                return 0;
            }


        }

        return dp[s.length()];

    }
}
