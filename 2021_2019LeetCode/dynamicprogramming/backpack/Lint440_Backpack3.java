package dynamicprogramming.backpack;

public class Lint440_Backpack3 {
    /**
     * 给定 n 种物品, 每种物品都有无限个. 第 i 个物品的体积为 A[i], 价值为 V[i].
     *
     * 再给定一个容量为 m 的背包. 问可以装入背包的最大价值是多少?
     * @param A
     * @param V
     * @param m
     * @return
     */

    public int backPackIII(int[] A, int[] V, int m) {
        int n = A.length;
        int[][] dp = new int[n+1][m+1];
        // dp[i][j] -> max value from given size of j, for up to i items, where each time can be taken INFINITE times

        // dp[i][j] = Math.max(dp[i-1[[j], // not taking i
        // --------------> dp[i-1][j - A[i-1]] + V[i-1]                // taking i item
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j]  = dp[i-1][j]; // This dp's property

                // 无限的概念 --> while loop
                int curCapacity = j;
                int count = 0;
                while (curCapacity >= A[i-1]) {
                    // 无限加 只要有空间
                    curCapacity -= A[i-1];
                    count ++;

                    dp[i][j] = Math.max(
                            dp[i][j],
                            // 你看着这 curCapacity 有增加
                            dp[i - 1][curCapacity] + V[i - 1] * count
                    );


                }
            }
        }

        return dp[n][m];
    }
}
