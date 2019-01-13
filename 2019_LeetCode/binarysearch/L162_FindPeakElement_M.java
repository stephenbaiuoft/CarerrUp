package binarysearch;

/*
* A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.

* */


/**
 * 解体思路： sorted -> 画图分析
 *
 * 然后 考虑下 给你的 nums[i] != nums[i+1] ==> 意味着什么？？  就是比较一下 然后 就知道 一些情况 必须exist 满足条件的peak对不对
 */

public class L162_FindPeakElement_M {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right-left)/2;
            // only 2 cases, given nums[i] != nums[i+1]
            if (nums[mid] < nums[mid+1]) {
                left = mid + 1; // update left, we know there has to exist one [mid+1, right]
            } else {
                right = mid; // update right, we know there has to exist one [left, right];
            }
        }

        return left;
    }
}
