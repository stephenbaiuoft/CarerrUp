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
        if (nums.length == 0) return -1;
        if (nums.length ==1)
            return nums[0] == target ? 0: -1;

        // binary search for index where
        // [1 to nums.length-1]
        // i (nums[i] > nums[i-1] && nums[i] > nums[i+1])
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left)/2;
            // [left ,mid,  right]
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // the one to the right
        int minIndex = left;
        left = target <= nums[nums.length-1] ? minIndex: 0;
        right = target > nums[nums.length-1] ? minIndex-1: nums.length-1;

        // boundary condition
        return bfs(left, right, target, nums);



    }

    protected int bfs(int left, int right, int target, int[] nums) {
        while (left < right) {
            int mid = left + (right-left)/2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else { // target <= nums[mid]
                right = mid;
            }
        }

        return nums[left] == target ? left: -1;
    }

//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return -1;
//
//        int minIndex = getMinIndex(nums);
//
//        int left = target > nums[nums.length-1]? 0: minIndex;
//        int right = target <= nums[nums.length-1]? nums.length-1: minIndex-1;
//        while(left < right) {
//            int mid = left + (right -left)/2;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else { // mid <=target
//                right = mid;
//            }
//        }
//
//        return nums[left] == target ? left: -1;
//
//    }
//
//    private int getMinIndex(int[] nums) {
//        int left = 0;
//        int right = nums.length -1;
//        while (left < right) {
//            int mid = left + (right - left)/2;
//            // we know that
//            if (nums[mid] > nums[right]) {
//                left = mid + 1;
//            } else { // mid <= right
//                right = mid;
//            }
//        }
//        return left;
//    }
}
