package Leetcode;

import java.util.*;

public class L15_M {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rez = new LinkedList<>();
        if (nums == null || nums.length < 1) return rez;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicates
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            // look for 2 sum here
            List<Integer> l = new LinkedList();
            l.add(i);
            int val = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < val) {
                    left++;
                } else if (sum > val) {
                    right--;
                }
                // equal case then remove duplicates!!!!!!!
                else {
                    rez.add(new LinkedList<>(Arrays.asList(nums[i],
                            nums[left],
                            nums[right])));
                    left++;
                    right--;
                    // skip duplicates
                    while( left < right &&
                            nums[right] == nums[right+1]) right--;
                    while( left < right && nums[left] == nums[left-1]) left++;
                }

            }

        }
        return rez;
    }

}
