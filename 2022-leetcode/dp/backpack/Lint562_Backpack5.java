package dp.backpack;

public class Lint562_Backpack5 {
    /**
     * 给出 n 个物品, 以及一个数组, nums[i]代表第i个物品的大小, 保证大小均为正数并且没有重复, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
     * 每一个物品可以使用无数次
     * @param nums
     * @param target
     * @return
     */
    public int backPackIV(int[] nums, int target) {
        // define dp[i][j] as
        // for given i number of items, for the size of j, the maximum you'd be able to get
        int[][] dp = new int[nums.length + 1][target + 1];
        int n = nums.length;
        // dp[i][j] = dp[i-1][j] // i item not given, but j is met (the dp characteristic
        //          + dp[i-1][j-A[i]] // i item not given, take i item, and j - A[i]

        // now for this given dp, when the j is 0, then dp[i][0] = 1, given 0 means that it has been found
        for (int itemGiven = 0; itemGiven <= n; itemGiven++) {
            dp[itemGiven][0] = 1;
        }

        for (int itemGiven = 1; itemGiven <= nums.length; itemGiven++) {
            for (int j = 1; j <= target; j++) {
                // function characteristic
                dp[itemGiven][j] = dp[itemGiven - 1][j];

                int count = 1;
                while (j - count*nums[itemGiven-1] >= 0 ) {
                    dp[itemGiven][j] += dp[itemGiven-1][j - count*nums[itemGiven-1]];
                    count ++;
                }
            }
        }

        // return the dp method
        return dp[nums.length][target];
    }

    public int solutionSimilar(int[] nums, int target) {
        int m = target;
        int[] A = nums;
        int f[][] = new int[A.length + 1][m + 1];

        f[0][0] = 1;
        for(int i = 1; i <= A.length; i ++){
            for (int j = 0; j <= m; j ++){
                int k = 0;
                while(k * A[i - 1] <= j ){
                    f[i][j] += f[i - 1][j - k* A[i -1]];
                    k ++;
                }
            }
        }

        return f[A.length][m];
    }
}
