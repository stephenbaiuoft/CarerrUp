package recursion_subproblem;

/*
* Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.



Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

* */

import java.util.Arrays;

/* 解体思路
    1. every number needs to be in ONE set
    2. all set equal number --> so it is sum/k, and you may not have remainders
    3. SortAlgo, but how(?)

假设 这个set的排序存在
- every number must be in some set
- so, if we sort the list in smallest to largest order, then we know
    1. a1,.....a_n, then we know if there exists some sub [..., a_n], then when we try to add to the list,
        the sum should not exceed the kAverage
    2. given its the sum over k brackets, and we define a SortAlgo function where
        public boolean search(int[]groups, int rowIndex, int target), where
    2.1 for the given rowIndex, all indices after rowIndex(going from right the left) has been fitted to some groups for sure
    2.2 so the base case--> if you can put in the last element, then each group must have been evaluated to the average value given
        our false statement is when you cannot add it to group[i] if adding the value exceeds the average


 */
public class L698_PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums==null || nums.length < 1) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum%k > 0) return false;
        int target = sum/k;

        Arrays.sort(nums);
        int rowIndex = nums.length-1;
        if (nums[rowIndex] > target) return false;
        while (rowIndex>=0 && nums[rowIndex] == target) {
            rowIndex--;
            k--;
        }
        return search(new int[k], nums, rowIndex, target);
    }


    private boolean search(int[] groups, int[] nums, int rowIndex, int target) {
        if (rowIndex < 0) return true; // added last one
        int valueToPut=nums[rowIndex--];

        for(int i = 0; i < groups.length; i++) {
            // always go from the first group to the last group
            if (groups[i]+valueToPut <= target) {
                groups[i] += valueToPut; // explore
                if (search(groups, nums, rowIndex, target)) return true;
                groups[i] -= valueToPut; // backtrack
            }

            // stop exploring this routine
            if (groups[i] ==0) break;
        }
        // once you reached here, meaning you cannot add it to any of the group, so false
        return false;
    }

}
