package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L15_3Sum_M {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rez = new LinkedList<>();
        // from right to left
        int i = nums.length - 1;
        int left = 0;
        int right = nums.length -1 ;
        if (nums == null || nums.length == 0 ) {
            return rez;
        }
        // sort the array
        Arrays.sort(nums);
        while(i > 1 && nums[i] >= 0) {
            left = 0;
            right = i-1;
            while(left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == 0) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[left]);
                    sol.add(nums[right]);
                    rez.add(sol);
                    // get rid of duplicate solutions
                    while(left+1 < right && nums[left] == nums[left+1]) {
                        left +=1;
                    }
                    while(right-1 > left && nums[right] == nums[right-1]) {
                        right -=1;
                    }
                    // increment left and right
                    left +=1;
                    right -=1;
                }
                else if (tmp < 0) {
                    left +=1;
                }
                else {
                    right -=1;
                } }
            while(i > 1 && nums[i]==nums[i-1]) {
                i -= 1;
            }
            i -= 1;
        }
        return rez;
    }
}
