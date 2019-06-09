package DP;

/*
*
There are a row of n houses, each house can be painted with one of the k colors.
The cost of painting each house with a certain color is different.
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix.
For example, costs[0][0] is the cost of painting house 0 with color 0;
costs[1][2] is the cost of painting house 1 with color 2, and so on...
Find the minimum cost to paint all houses.

Example
Example 1

Input:
costs = [[14,2,11],[11,14,5],[14,3,10]]
Output: 10
Explanation:
The three house use color [1,2,1] for each house. The total cost is 10.

* */

/*
* DP[i][j] the min cost of painting house i with color j
* DP[i][non_j] the min cost of painting house i with color other than j
*
* Complexity Analysis --> O(n*K&K)
*       O( n, --# of houses--,  *  K,  --#of choices--, * K --# for the minimum each time )
*
*
* 所有的优化 都是可以从 动态规划的公式开始的优化的
* Dynamic Equation
*
*    DP[i][j] =     min {DP[i-1][non_j]} + c[i][j]
*
*   final    minC=> = min {DP[i][j]}, j from 1~K
*
*
* 优化：
*    只需要 j_that_is_min0 -> min {DP[i-1][j_that_is_min0]}
*           j_that_is_min1 -> min {DP[i-1][j_that_is_min1]}
*
*   因为这样你就知道 反正你如果当前能选某个颜色 j_current for some value, 就update 一下 j_min0 j_min1顺便
* */
public class L516_PaintHouseII {
    public L516_PaintHouseII() {
        int[][] costs = {
                new int[]{14,2,11},
                new int[]{11,14,5},
                new int[]{14,3,10}
        };

        int c = minCostII(costs);
        System.out.println(c);
    }


    public int minCostII(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) return 0;

        int minIndex = 0; // DP[0][anything] is 0 as default....
        int secondMinIndex = minIndex; // the second smallest index

        int house = costs.length; // # of houses
        int color = costs[0].length; // # of colors
        int[][] dp = new int[house+1][color+1];
        int minCost = Integer.MAX_VALUE;

        for (int h = 1; h <= house; h++) {


            for (int c = 1; c <= color; c++ ) {
                // if c was the previous minJ0
                if (c == minIndex) {
                    dp[h][c] = dp[h-1][secondMinIndex] + costs[h-1][c-1]; // second smallest
                }
                else { // not colliding against the last min index
                    dp[h][c] = dp[h-1][minIndex] + costs[h-1][c-1];
                }
            }

            int minValue = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;

            // when the entire level is OVER then we do the loop!!! for the minIndex and the next smallest minIndex
            for (int c = 1; c <= color; c++ ) {
                //
                if (dp[h][c] < minValue) {
                    // update value
                    secondMin = minValue;
                    minValue = dp[h][c];

                    // update index
                    secondMinIndex = minIndex;
                    minIndex = c;
                }
                else if (dp[h][c] < secondMin) { // this is the case where you got a value that is > minValue, but < current secondMin
                    secondMin = dp[h][c];
                    secondMinIndex = c; // update the secondMinIndex
                }
            }

        }

        for (int c = 1; c <= color; c++) {
            minCost = Math.min(minCost, dp[house][c]);
        }

        return minCost;
    }
}
