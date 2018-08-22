package Leetcode;

/*
* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    Example 1:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    Example 2:

    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]
* */
public class L34_M {
    public L34_M() {
        int[] input = {5,7,7,8,8,10};
        int val = 8;
        int rez = findUpperBound(input, val);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] rez = {-1, -1};
        if (nums == null || nums.length < 1) return rez;

        int left = findLowerBound(nums, target);
        int right = findUpperBound(nums, target);
        if (nums[left] != target) return rez;
        rez[0] = left;
        rez[1] = right;
        return rez;
    }

    // log(n)
    private int findLowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            // nums[mid] >= target
            else {
                right = mid ;
            }
        }
        return left;
    }

    private int findUpperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right && left != right -1) {
            int mid = left + (right -left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            }
            // nums[mid] > target
            else {
                right = mid - 1;
            }
        }
        return nums[right] == target? right: left;
    }
}
