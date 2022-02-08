package binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class binary_search_test {


    public binary_search_test() {
        int[] n1 = new int[] {0, 100};
        int[] n2 = new int[] {0, 80,100};
        showResult(n1, 99);
        showResult(n2, 39);
    }

    private void showResult(int[] nums, int target) {
        for (int n: nums) {
            System.out.print(n + ",");
        }
        System.out.println("\tend of nums " + "with target: " + target);

        System.out.println("naive approach: " + getVal(nums, target));
        System.out.println("closest element approach: " + findClosestElement(nums, target));

        System.out.println("\n\n");
    }
/*
Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
*
*
* 最好的template 你看 k = 1 的时候 你怎么做
* */
    public int findClosestElement(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            // mid is far away from target
            if (Math.abs(arr[mid] - target) > Math.abs(arr[mid+1] - target)) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return arr[left];
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x)     {
        // provided k >= 1
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) /2;
            // this determines how to shift the range
            if ( Math.abs(arr[mid] -x)  > Math.abs(arr[mid + k] - x) ) {
                // because the range can start from mid + 1 as the
                // arr[mid] is more than the arr[mid+k]
                left = mid + 1;
            } else { // arr[mid] - x <= arr[mid+k] - x
                // then, this range [mid, mid + k - 1] is safe comparing to  mid + k because of this comparison!!!!!!!
                right = mid;
            }
        }

        List<Integer> list = new LinkedList<>();
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }

        return list;
        
    }

    // return the value closet to target
    public int getVal(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else { // nums[mid] <= target
                right = mid;
            }
        }

        // return the value
        return nums[left];
    }
}
