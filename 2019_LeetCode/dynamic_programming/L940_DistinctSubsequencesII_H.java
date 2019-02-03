package dynamic_programming;

import java.util.Arrays;

/*
*
Given a string S, count the number of distinct, non-empty subsequences of S .

Since the result may be large, return the answer modulo 10^9 + 7.



Example 1:

Input: "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
Example 2:

Input: "aba"
Output: 6
Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
Example 3:

Input: "aaa"
Output: 3
Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
*
* */

//思路：这个dp很难归纳 讲道理
// 1. 要加入empty set 才能发现 distinct element 如果每一次都是 那么数量就是double
// 2.
// 可以从1，2，3 一个一个开始


//
public class L940_DistinctSubsequencesII_H {
    public L940_DistinctSubsequencesII_H() {
        String s = "aa";
        int rez = distinctSubseqIISol(s);
        System.out.println(rez);
    }


    public int distinctSubseqIISol(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();
        int[] dp = new int[N+1];
        dp[0] = 1;

        // used to store the dp index of the latest last character digit
        int[] last = new int[26];
        // do it in dp way
        for (int i = 1; i <= N; i++) {
            // get the lastCDigit value
            int endDigit = S.charAt(i-1) - 'a';
            dp[i] = 2 * dp[i-1] % MOD;
            // it's value is only from [1,N] possib
            if (last[endDigit] > 0) {
                // last[endDigit] gives the last index ending with the character
                // last[endDigit] - 1 gives the dp index before then,
                // which means in other words --> the number that can be double counted
                dp[i] -= dp[last[endDigit]-1];
            }
            dp[i] %= MOD;
            // update this value
            last[endDigit] = i;
        }

        // removes the "" count
        dp[N]--;
        // overflow
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N];
    }

    // 这个就是不算empty set 但是 有一个1的offset 你要注意
    // 如果第一次见到new character 要就要+1
    // 如果不是第一次 那这个+1 就不需要了
    // dp[i] = 2 * dp[i-1] - dp[last[s[i] - 1] ( last[s[i]] > 0: 就是这个character 已经出现过了
    //  OR   = 2 * dp[i-1] + 1 //如果这个character是第一次出现

    public int distinctSubseqIIApproach2(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();
        int[] dp = new int[N+1];
        // used to store the dp index of the latest last character digit
        int[] last = new int[26];

        // do it in dp way
        for (int i = 1; i <= N; i++) {
            // get the lastCDigit value
            int endDigit = S.charAt(i-1) - 'a';
            dp[i] = 2 * dp[i-1]  % MOD;
            // it's value is only from [1,N] possib
            if (last[endDigit] > 0) { // can't add to it
                // last[endDigit] gives the last index ending with the character
                // last[endDigit] - 1 gives the dp index before then,
                // which means in other words --> the number that can be double counted
                dp[i] -= dp[last[endDigit]-1];
            } else { // add 1 if for the first time having a new character
                dp[i] = (dp[i]  + 1)% MOD;
            }

            dp[i] %= MOD;
            // update this value
            last[endDigit] = i;
        }

        // java modulo returns negative if the value is negative due to overflow
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N] % MOD;
    }
}
