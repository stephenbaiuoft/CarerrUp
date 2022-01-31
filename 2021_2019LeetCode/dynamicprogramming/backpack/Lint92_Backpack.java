package dynamicprogramming.backpack;

import java.util.Arrays;

public class Lint92_Backpack {
    public Lint92_Backpack() {
        int[] nums = {3, 4, 8,5};
        backPack(10, nums);
    }


    // https://www.lintcode.com/problem/92/
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */

    // https://www.jiuzhang.com/solution/backpack/
    // 2-D backpack
    public int backPack(int m, int[] A) {
        // Define dp such that
        int[][] dp = new int[A.length+1][m+1];
        // dp[i][j] = the maximum space by ith time with j space, where i is [1, A.length]

        // item 代表 你能一开始 有多少个选择 (item = 1, 只有一个选择， item = 2， 有2个选择, item =3 3个选择
        for (int item = 1; item <= A.length; item++) {
            for (int size = 1; size <= m; size++) {
                // By default, the characteristic of this dp method is
                // dp[item][size] is at least >= dp[item-1][size] ( the maximum space by it's previous # of items offered [item-1], given its left to right
                // Why? it's item - 1????? because the i is on the outer loop
                dp[item][size] = dp[item - 1][size];

                // Now can we take this item??
                if (size >= A[item-1]) {
                    dp[item][size] = Math.max(
                            dp[item - 1][size - A[item-1]] + A[item-1], // Take this item, and get dp[item][size - A[item] ,
                            // 这里 ===> Why item -1?? 因为只能take 一次， 所以i-1 meaning 上一个最多多少 不包括i item在能放下新的size下
                            dp[item - 1][size] // Do not take this item
                    );
                }
            }
        }

        // the max we can get
        return dp[A.length][m];
    }

    // 滚动数组优化
    public int backPack1D(int m, int[] A) {

        int n = A.length;

        // Define dp such that
        int[] dp = new int[m+1];
        // dp[j] = the maximum space by ith time with j space

        for (int i = 0; i < n; i++) {
            // /滚动数组优化 倒序枚举j, j needs to be larger than A[item]
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(
                       dp[j], // for max size of j, up to getting item = 1, | or for max size of j, up to getting item = 2
                        // 那如果是 i= 3的时候， 那 dp[j] 能选到第3个物品的 是不是至少是 dp[j] 能选到第二个物品 的价值？？？ 是的
                        dp[j - A[i]] + A[i]); // 以及这次 我选第3个物品 能得到的最大的价格
            }
        }

        // the max we can get
        return dp[m];
    }

    public int backPack1DSolution(int m, int[] A) {
        // write your code here
        // 如果背包容量或者物品数量为0，则直接返回
        if (A.length == 0 || m == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            // 滚动数组优化 倒序枚举j
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
        return dp[m];
    }

}
