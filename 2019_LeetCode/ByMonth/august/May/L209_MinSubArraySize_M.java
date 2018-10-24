package ByMonth.august.May;

public class L209_MinSubArraySize_M {
    public int minSubArrayLenSol(int s, int[] nums) {
        if(nums == null) return 0;

        int sum = 0, left = 0, right = 0, minVal = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum += nums[right++];

            while(sum >= s) {
                minVal = Math.min(minVal, right - left);
                sum -= nums[left++];
            }

        }

        return minVal == Integer.MAX_VALUE ? 0: minVal;
    }

    // slow solution !!! very very slow but AC
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        // base condition check
        if(nums[nums.length-1] < s) return 0;

        int minVal = nums.length;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= s) {
                // base condition first
                minVal = Math.min(minVal, i + 1);
                for(int j = i-1; j > -1 ; j--) {
                    if(nums[i] - nums[j] >= s ) {
                        minVal = Math.min(minVal, i-j);
                        // no need to reduce as minVal only gets larger
                        break;
                    }
                }
            }
        }

        return minVal;
    }
}
