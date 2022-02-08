package dynamicprogramming;

public class L312BurstBalloons {


    public L312BurstBalloons() {
        int[] a = {3, 1, 5, 8};
        maxCoins(a);


    }

    public int maxCoinsTopDown(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = a[a.length - 1 ] = 1;

        for (int i = 0; i < n; i++) {
            a[i+1] = nums[i];
        }

        // dp to store max values you'd get between i and j
        // we'd have n+2 due to i,
        int[][] dp = new int[n + 2][ n + 2];

        // We'd get the max between 1 and n for the array a
        return dpTopDown(a, dp,1, n);
    }


    // Let's do top down
    public int dpTopDown(int[] a, int[][] dp, int start, int end) {
        // return base condition
        if (start > end) {
            // do not cross??? --> no value doing so
            return 0;
        }
        // Value has been updated stored
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        // i <= j
        // Need to compute,
        // dp[i][j] =
        for (int indexToPopLast = start; indexToPopLast <=end; indexToPopLast++) {
            dp[start][end] = Math.max(
                    dp[start][end],
                    // up to indexToPopLast
                    dpTopDown(a, dp, start, indexToPopLast - 1)
                    +
                            a[start - 1] * a[indexToPopLast] * a[end+1]
                    + dpTopDown(a, dp, indexToPopLast + 1, end)
            );
        }

        // return this value
        return dp[start][end];
    }

    /**
     * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
     *
     * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
     *
     * Return the maximum coins you can collect by bursting the balloons wisely.
     * @param nums
     * @return
     *
     *
     * 要求
     *
     * n == nums.length
     * 1 <= n <= 500
     * 0 <= nums[i] <= 100
     *
     * all --> nums[i] >= 0 (including 0)
     */
    public int maxCoins(int[] nums) {

        // 思路 一般如果和 已有的 non order的第几次有关 可以用len 大小来代表 因为len可以不管中间选择的次数

        // n size of the nums, the length
        int n = nums.length;

        // define dp[i][j] as the maximum value between i && j
        int[][] dp = new int[nums.length+2][nums.length+2];

        // define a as the boundary array, that is [1, ......, 1]
        int[] a = new int[nums.length+2];
        a[0] = a[a.length-1] = 1;
        for (int i = 0; i < nums.length; i++) {
            a[i+1] = nums[i];
        }


        // define len = right - left
        // given all lens (Also note, len = 1 depends on len = 0, this is the order, hence len is the outer loop
        for (int len = 0; len < nums.length; len ++) {
            /**
             * n = 4 ----> len [0, 1, 2, 3]
             * nums -> [3, 1, 5, 8]
             * a -> [1, 3, 1, 5, 8, 1]
             * nums [0, 1, 2, 3, 4, 5]
             */
            // start on the a array
            // start from left, and let's go through all indices within nums
            for (int left = 1; left + len <= n ; left++) {
                // rightMost is the end of left + len
                int rightMost = left + len;
                // Use indexToPopLast -> means this will be chosen at last
                for (int indexToPopLast = left; indexToPopLast <= rightMost; indexToPopLast++) {

                    // Within this range, we'd go through all the indexToPopLast
                    dp[left][rightMost] =
                            Math.max(
                                    dp[left][rightMost],
                                    // VS
                                    dp[left][indexToPopLast-1] // the max value from left to indexToPopLast
                                    + a[left-1] * a[indexToPopLast] * a[rightMost + 1] // nums[left - 1] exists && nums[right + 1] exists
                                    + dp [indexToPopLast+1][rightMost] // the max value from indexToPopLast to right
                            );

                }
            }
        }

        // return the max you'd get from 1 and n
        return dp[1][n];
    }

    public int maxCoinssolution(int[] nums) {
        int n = nums.length;

        int[] a = new int[n+2];
        // left most and right most all equal to 1
        a[0] = a[nums.length + 1] = 1;
        // dp used to record the value
        // dp[i][j] denotes the maximum value you can burst out between i and j inclusively
        int[][] dp = new int[a.length][a.length];

        for (int i = 0; i < n; i++) {
            a[i+1] = nums[i];
        }

        // dp[i][j] denotes the maximum value you can burst out between i and j!!!!!! 超级重要 记得你dp的定义是什么
        for (int len = 0; len <= n; len++) {
            // let's do left and right pairs, with len (left, right)这个pair equal to 0 is okay
            for (int left = 1; left + len <= n; left++) {
                int rightMost = left + len; // --> 因为 [left,rightMost] so that in this order,
                // dp[left][right] means the maximum you can get between dp[left][right]
                // and it is just all the possible burstChoiceOfCurLen, given the current length
                for(int burstChoiceOfCurLen = left; burstChoiceOfCurLen <=rightMost; burstChoiceOfCurLen++) {
                    dp[left][rightMost] = Math.max(
                            dp[left][rightMost],
                            dp[left][burstChoiceOfCurLen-1] + dp[burstChoiceOfCurLen+1][rightMost] +
                                    a[left-1] * a[burstChoiceOfCurLen] * a[rightMost+1] );
                    // we use a[left-1] 因为given the len 我们可以选择 把burstChoiceOfCurLen成为最后一个
                    // 所以就是 a[left-1] * a[burstChoiceOfCurLen] * a[rightMost+1]
                }


            }
        }

        return dp[1][n]; // the maximum you can get between [1, n] inclusively for the given array
    }
}
