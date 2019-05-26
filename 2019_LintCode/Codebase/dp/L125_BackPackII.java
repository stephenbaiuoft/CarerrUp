package Codebase.dp;

/*

There are n items and a backpack with size m. Given array A representing the size of each item and array V representing the value of each item.

What's the maximum value can you put into the backpack?

A[i], V[i], n, m are all integers.
You can not split an item.
The sum size of the items you want to put into backpack can not exceed m.
Have you met this question in a real interview?
Example
Example 1:

Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
Output: 9
Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9

*
* */


public class L125_BackPackII {
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here

        // dp[i][capacity] => maximum value you can get putting up to, considering up to i # of items ( or go through an ith item)
        //          => AND with the size of j
        int[][] dp = new int[A.length+1][m+1];
        for (int i = 1; i <= A.length; i++) {
            for (int capacity = 1; capacity <= m; capacity++) {
                if (A[i-1] > capacity) { // case 0:  can't put in A[i] item, then up to i item, you would inherit from previous one
                                         // Note WE ARE UISNG DP Index here!!!! okay, A[i] really refers to A[i-1] in the code!!!
                    dp[i][capacity] = dp[i-1][capacity];
                }
                else if (A[i-1] <= capacity) {
                    dp[i][capacity] = Math.max(
                            dp[i-1][capacity], // Don't put in this value previous max value
                            dp[i-1][capacity - A[i-1]] + V[i-1] // Put this value in, then
                    );
                }

            }
        }

        // max up to the last item, given maximum size of m
        return dp[A.length][m];
    }
}
