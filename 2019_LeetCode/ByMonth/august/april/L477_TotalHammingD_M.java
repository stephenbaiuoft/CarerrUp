package ByMonth.august.april;

public class L477_TotalHammingD_M {
    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;

        while(true) {
            int zeroCount = 0;
            int bitOne = 0;
            int bitZero = 0;
            for(int i = 0; i < nums.length; i++) {
                // each significant bit for every number
                if (nums[i] % 2 == 0) {
                    bitZero ++;
                    if (nums[i] == 0) {
                        zeroCount++;
                    }
                } else {
                    bitOne ++;
                }
                // shift each value 1 bit to the right
                nums[i] = nums[i] >> 1;
            }

            sum = sum + bitOne * bitZero;
            if(zeroCount == nums.length) {
                return sum;
            }
        }

    }
}
