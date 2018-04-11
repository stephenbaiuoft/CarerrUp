package March;

import java.util.Arrays;

public class L16_3SumCloset_M {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;

        int minValue = Integer.MAX_VALUE;
        int minSum = 0;

        Arrays.sort(nums);
        // 3 sum solution and check for min value
        for(int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            // loop for 2 sum
            int left = i +1;
            int right = nums.length - 1;
            while(left < right) {
                int delta =  v - nums[left] - nums[right] ;
                if (delta == 0) return target;
                else {
                    int absDelta = Math.abs(delta);
                    if (absDelta < minValue) {
                        minValue = absDelta;
                        minSum = nums[i] + nums[left] + nums[right];
                    }
                    if (delta < 0) {
                        right--;
                    }
                    else {
                        left++;
                    }

                }
            }
        }
        return minSum;
    }
}
