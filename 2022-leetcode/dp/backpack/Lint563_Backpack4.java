package dp.backpack;

public class Lint563_Backpack4 {
    /**
     * 给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小, 保证大小均为正数, 正整数 target 表示背包的大小,
     * 找到能填满背包的方案数。
     * 每一个物品只能使用一次
     *
     * @return
     */
    public Lint563_Backpack4() {
        int[] nums = {1, 2, 3, 3, 7};

        int rez = backPackV(nums
        , 7);

        System.out.println("rez is " + rez);
    }


    public int backPackV(int[] nums, int target) {
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

                if (j >= nums[itemGiven-1]) {
                    dp[itemGiven][j] += dp[itemGiven-1][j - nums[itemGiven- 1]];
                }
            }
        }

        // return the dp method
        return dp[nums.length][target];

    }

    public int backPackVTopDown(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+1];
        return dpTopDownCompute(nums, dp, nums.length, target);
    }

    // dp compute
    // for given i item, and j capacity, maximum # of combinations
    public int dpTopDownCompute( int[] nums, int [][]dp, int i, int j) {
        // Base conditions
        // No more required, found at least 1
        if (j == 0 ) return 1;
        // i = 0, no more items available
        // j < 0, not possible to get
        if (i <= 0 || j < 0 ) return 0;

        // if computed already, return the value
        if (dp[i][j] != 0) return dp[i][j];

        // For this method
        dp[i][j] =
                dpTopDownCompute(nums, dp, i-1, j) // you'd defintely get dpTopDownCompute[i-1, j] for sure
                + // PLUS
                dpTopDownCompute(nums, dp, i-1, j - nums[i-1]); // any additional ones from item i (for nums it'd be nums[i-1]

        return dp[i][j];
    }




    // DFS timing out solution
    // compute # of possible for a given value
    public int compute(int[] nums, int target, int toVisit) {
        // no negative number, or reaching end of array
        if (target < 0) return 0;
        // target = 0, no need to continue looking return 1
        if (target == 0) return 1;
        if (toVisit == nums.length) return 0;

        int count = 0;
        for (int i = toVisit ; i < nums.length; i++) {

            count += compute(nums, target  - nums[i], i + 1);
        }

        return count;
    }
}
