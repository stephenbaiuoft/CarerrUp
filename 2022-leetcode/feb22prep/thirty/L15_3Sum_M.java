package feb22prep.thirty;

import java.util.*;

public class L15_3Sum_M {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // remove duplicates!!!
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int target = 0 - nums[i];

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    right -=1;
                    // Remove duplicates
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }

                } else if (sum < target) {
                    left++;
                } else { // sum > target, move right
                    right --;
                }

            }
        }

        return result;
    }

}
