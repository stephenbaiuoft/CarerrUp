package twopointers.hashmap.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
*
* Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*
*
* */
public class L18_4Sum_M {
    public L18_4Sum_M() {
        int[] test = new int[] {
                2, 1, 0, -1
        };

        List<List<Integer>> rez = fourSum(test, 2);

    }
    // let's write a modular expression or idea
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums == null || nums.length < 4) return list;

        Arrays.sort(nums);
        if (get4Sum(nums, 0) > target ||
            get4Sum(nums, nums.length - 4) < target    ) {
            return list;
        }

        // here let's apply the 4 sum logic on top of the 3 sum logic
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            threeSumHelper(nums, list, i+1, nums[i], target);
        }

        return list;
    }

    private int get4Sum(int[] nums, int startIndex) {
        int sum = 0;
        for (int i = startIndex; i < startIndex+4; i++) {
            sum += nums[i];
        }

        return sum;
    }

    // given start index, find the 3sum, with val that equals to target
    private void threeSumHelper(int[] nums, List<List<Integer>> list, int start, int val, int target) {

        for (int i = start; i < nums.length - 2; i++) {
            // remove duplicates
            if (i > start && nums[i-1] == nums[i]) {
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            int sum = 0;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right] + val;
                if (sum == target) {
                    List l1 = new LinkedList();
                    l1.add(val);
                    l1.add(nums[i]);
                    l1.add(nums[left]);
                    l1.add(nums[right]);
                    list.add(l1);

                    // update left and right indice
                    left++;
                    right--;
                    // remove duplicates for left and right pointer
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while(right > left && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
                else if (sum < target ) {
                    left ++;
                } else { // sum > target
                    right--;
                }

            }

        }
    }

    // the following is the threeSum algorithm
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // remove duplicates
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            int sum = 0;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List l1 = new LinkedList();
                    l1.add(nums[i]);
                    l1.add(nums[left]);
                    l1.add(nums[right]);
                    list.add(l1);

                    // update left and right indice
                    left++;
                    right--;
                    // remove duplicates for left and right pointer
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while(right > left && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
                else if (sum < 0 ) {
                    left ++;
                } else { // sum > 0
                    right--;
                }

            }

        }
        return list;
    }
}
