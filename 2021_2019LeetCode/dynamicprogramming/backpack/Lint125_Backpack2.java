package dynamicprogramming.backpack;

public class Lint125_Backpack2 {
    // https://www.lintcode.com/problem/125

    /**
     * 有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
     *
     * 问最多能装入背包的总价值是多大?
     * @param m
     * @param A
     * @param V
     * @return
     */


    // Challenge??
    // 你能把空间复杂度优化为O(m)吗？
    public int backPackII1D(int m, int[] A, int[] V) {
        // Same as before只是改了value的对应的地方
        int n = A.length;
        int[] dp = new int[m+1];

        for (int i = 1; i <=n; i++) {
            for (int j = m; j >= A[i-1]; j--) {
                dp[j] = Math.max(
                        dp[j],
                        dp[j - A[i-1]] + V[i-1]
                );
            }
        }

        return dp[m];

    }


    public int backPackII(int m, int[] A, int[] V) {
        // Same as before只是改了value的对应的地方
        int n = A.length;
        int[][] dp = new int[n+1][m+1];
        // dp[i][j] -> max value from given size of j, for up to i items

        // dp[i][j] = Math.max(dp[i-1[[j], // not taking i
        // --------------> dp[i-1][j - A[i-1]] + V[i-1]                // taking i item
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j]  = dp[i-1][j]; // This dp's property

                if (j >= A[i-1]) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i - 1][j - A[i - 1]] + V[i - 1]
                    );
                }
            }
        }

        return dp[n][m];

    }

}
