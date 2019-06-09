package DP;

/*
*
* Given two strings S and T. Count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not)

Have you met this question in a real interview?
Example
Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation: You could remove any 'b' in S, so there are 3 ways to get T.

* */
public class L118_DistinctSubsequencesII {
    // define
    // DP[i][j] the maximum # of distinct subsequences for i in S and j in T
    // DP[i][j] = if S.charAt(i) == T.charAt(j), we have 1 entires # more -> DP[i-1][j-1] + 1
    //            if S.charAt(i) != T.charAt(j), we use the previous one DP[i-1][j] previously matched one?

    public int numDistinct(String S, String T) {
        // write your code here
        // use s to match T every time, incrementing the size of s
        int[][] dp = new int[S.length()+1][T.length()+1];

        // any S to match "" would default to 1 combination
        for (int s = 0; s <= S.length(); s++) {
            dp[s][0] = 1;
        }

        // s and t both refer to DP
        for (int s = 1; s <= S.length(); s++) {
            for (int t = 1; t <= T.length(); t++) {
                dp[s][t] = dp[s-1][t]; // the at least you would have this many # of matches as your base
                if (S.charAt(s-1) == T.charAt(t-1)) {
                    dp[s][t] += dp[s-1][t-1]; // add in the count for DP[s-1][t-1]
                }
            }
        }

        return dp[S.length()][T.length()];

    }
}
