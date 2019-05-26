package Leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).


 */

public class L91_DecodeWays_M {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            //&& first <= 9 is not required as has to be
            if(first >= 1 ) {
                dp[i] = dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public void test() {
        numDecodingsTest("11");
    }

    public int numDecodingsTest(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        //store DP values
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i=2; i < s.length()+1; i++) {
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i));
            if (first > 0) {
                dp[i] = dp[i-1];
            }
            if (second >=10 && second <=26) {
                dp[i] += dp[i-2];
            }
        }

        // final result
        return dp[s.length()];

    }
}

