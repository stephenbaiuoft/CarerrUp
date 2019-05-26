package ByMonth.august.June;

import java.util.Arrays;

public class L516_LongestPalindromeSub_M {
    // 2 is memorization (SortAlgo back down)
    public int longestPalindromeSubseq2(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];


        char[] charSet = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i ; j < s.length(); j++) {
                getLength(i, j, s, dp);
            }
        }
        return dp[0][s.length()-1];

    }

    private int getLength(int i, int j, String s, int[][] dp) {
        // memorization
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        // 需要这个case  因为-->    i > j 在某些case之中 会发生的
        else if (i > j) {
            // should not happen here i think?
            return 0;
        }
        else if(i == j) {
            dp[i][j] = 1;
        }
        // case 1
        else if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = getLength(i+1, j -1, s, dp) + 2;
        }
        // case 2
        else {
            dp[i][j] = Math.max(getLength(i+1, j, s, dp),
                    getLength(i, j -1, s, dp));
        }

        return dp[i][j];
    }

    // 2-d array with DP
    public int longestPalindromeSubseq(String s) {
        // base condition check
        if (s == null || s.length() == 0) return 0;

        int[][] dp = new int[s.length()][s.length()];
        char[] charSet = s.toCharArray();

        // i, j to indicate the starting and ending indice
        int j = 0;
        for (int len = 1; len <= s.length(); len++){
            for(int i = 0; i <= s.length() - len; i++) {
                j = i + len - 1;
                if (i == j) {
                    // base case
                    dp[i][j] = 1;
                }
                // case 1
                else if (charSet[i] == charSet[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                // case 2
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
