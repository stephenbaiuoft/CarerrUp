package DP;

/*
*
* Given n kinds of items, and each kind of item has an infinite number available. The i-th item has size A[i] and value V[i].

Also given a backpack with size m. What is the maximum value you can put into the backpack?

Example
Example 1:

Input: A = [2, 3, 5, 7], V = [1, 5, 2, 4], m = 10
Output: 15
Explanation: Put three item 1 (A[1] = 3, V[1] = 5) into backpack.



* */
public class L440_BackpackIII {
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here

        int[][] dp = new int[A.length+1][m+1];
        for (int i = 1; i <= A.length; i++) {
            for (int s = 1; s <= m; s++) {
                dp[i][s] = dp[i-1][s]; // 上一个选择： 不选 i这个item 但是 size 是 s
                if ( s >= A[i-1]) {
                    dp[i][s] = Math.max(
                            dp[i-1][s], // not picking current ith item, and for the given size s
                            dp[i][s - A[i-1]] + V[i-1] // 上一次选了 i， 最大的size是 s-A[i]的max value + V[i-1]
                            // 这里其实是覆盖 DP[i][s-A[i-1]] ⚠️注意⚠️ --》 这里是i!!!!!! 看到了嘛？
                    );
                }
            }
        }

        return dp[A.length][m];
    }
}
