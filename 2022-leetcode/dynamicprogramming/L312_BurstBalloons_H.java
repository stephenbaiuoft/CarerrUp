package dynamicprogramming;

/*
Given n balloons, indexed from 0 to n-1.
Each balloon is painted with a number on it represented by array nums.
You are asked to burst all the balloons.
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
* */

// 思路 -> DP
// 把len为0， 1， 一直到n-1都算出来
// 注意 你dp的定义 DP[i][j] 是 maximum amount you can get between [i,j] inclusively!
// 所以举个例子 DP[2][6] 当len = 4的时候 肯定是建立于 之前的打dp的运算结果
// 这时候 你可以选择 a[1]* a[burstChoice]*a[7]  + DP[1][1] + DP[7][n]的运算结果

public class L312_BurstBalloons_H {

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] a = new int[n+2];
        // left most and right most all equal to 1
        a[0] = a[nums.length + 1] = 1;
        // DP used to record the value
        // DP[i][j] denotes the maximum value you can burst out between i and j inclusively
        int[][] dp = new int[a.length][a.length];

        for (int i = 0; i < n; i++) {
            a[i+1] = nums[i];
        }

        // DP[i][j] denotes the maximum value you can burst out between i and j!!!!!! 超级重要 记得你dp的定义是什么
        for (int len = 0; len <= n; len++) {
            // let's do left and right pairs, with len (left, right)这个pair equal to 0 is okay
            for (int left = 1; left + len <= n; left++) {
                int rightMost = left + len; // --> 因为 [left,rightMost] so that in this order,
                // DP[left][right] means the maximum you can get between DP[left][right]
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
