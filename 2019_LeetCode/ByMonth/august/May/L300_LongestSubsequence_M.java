package ByMonth.august.May;

import java.util.Arrays;

public class L300_LongestSubsequence_M {
    // n^2 solution with dp
    public L300_LongestSubsequence_M() {
        int[] input = new int[] {
             2,3,10,9,1,5,7,8
        };

        // this is a brilliant nlogn solution!!!
        int count = lengthOfLISSol(input);
    }

    // nlog n solution?
    public int lengthOfLISSol(int[] nums) {
        //http://www.algorithmist.com/index.php/Longest_Increasing_Subsequence
        /*
         think of insertion algorithm and also note
         [2],[3],[4],[1]  --> 1
         [2,3], [3,4]  ---> 3
         [2,3,4]     --> 4

         // longest -- > 3 with order of the elements of 1,3, 4 order
        */

        if (nums == null || nums.length < 1) return 0;

        // n*logn approach
        int length = 0;
        int[] tails = new int[nums.length];

        for(int number: nums) {
            // init for every number
            int iStart = 0, iEnd = length;
            int mid = 0;
            // binary search for the position to insert
            while(iStart != iEnd) {
                mid = (iStart + iEnd)/2;
                if (tails[mid] < number) {
                    iStart = mid + 1;
                }
                else {
                    // tails[mid] >= number
                    iEnd = mid;
                }
            }

            // iStart is really the insertion index
            // if it's the last to insert, mid is already incremented by 1
            tails[iStart] = number;
            // value to insert is @ the end as iStart
            if(iStart == length) {
                length ++;
            }
        }

        return length;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        // fill dp with 1s
        Arrays.fill(dp, 1);

        int n = nums.length;
        int maxVal = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = 0; i < nums.length; i++) {
            maxVal = Math.max(dp[i], maxVal);
        }

        return maxVal;

    }
}
