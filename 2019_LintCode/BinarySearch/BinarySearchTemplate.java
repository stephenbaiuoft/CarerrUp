package BinarySearch;

import java.util.Arrays;

public class BinarySearchTemplate {
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        // write your code here
        int left = 0;
        int right = nums.length-1;
        while (left + 1 < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < target) {
                left = mid;
            } else { // target <= mid --> right = mid
                right = mid;
            }
        }

        //肯定大概率在right中 但是 当while-loop没有执行的时候！！！！
        // [8,10] left =0, right =1, target = 0, 那么 寻找target=8, 就需要这个情况
        return nums[right] == target? right:
                                      nums[left] == target? left: -1;
    }

    public int findPositionAlt(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        // write your code here
        int left = 0;
        int right = nums.length-1;
        while (left + 1 < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] <= target) { //无限向着左边靠齐
                left = mid;
            } else { // target < mid --> right = mid
                right = mid;
            }
        }

        //这里注意需要检查  为什么/？？？？ 因为你 left+1 < right， 但如果array的size 是2？ while-loop不会执行！！！！！！
        // 很重要!!!!!!!
        return nums[left] == target ? left:
                                      nums[right] == target ?right:  -1;
    }
}
