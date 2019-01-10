package binarysearch;

/*
*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


* */
public class L33_SearchRotatedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int minIndex = getMinIndex(nums);

        int left = target > nums[nums.length-1]? 0: minIndex;
        int right = target <= nums[nums.length-1]? nums.length-1: minIndex-1;
        while(left < right) {
            int mid = left + (right -left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else { // mid <=target
                right = mid;
            }
        }

        return nums[left] == target ? left: -1;

    }

    private int getMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int mid = left + (right - left)/2;
            // we know that
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // mid <= right
                right = mid;
            }
        }
        return left;
    }
}
