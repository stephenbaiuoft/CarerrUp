package March;

public class L152_MaxProductArray_M {

    public int maxProductII(int[] nums) {
        // 1 variable to keep track of min and max
        // in terms of magnitude ==>!!1
        int iMin = 1;
        int iMax = 1;
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            // swap!!!
            if(nums[i] < 0) {
                // this way, iMin is maxmized in terms of magnitude!!!
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }

            // always max value
            //  --> the magnitude is always kept track in iMax or iMin!!!!
            //   iMax is always positive so far
            //   iMin is always if flipped!!!!
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);

            maxValue = Math.max(iMax, maxValue);
        }

        return maxValue;
    }

    public int maxProduct(int[] nums) {
        // idea: always keep track of
        //      negativeArray + positiveArray
        //      to hold values up to index i so far!!
        // and @ each step, find the maxValue

        int[] dpPositive = new int[nums.length+1];
        int[] dpNegative = new int[nums.length+1];
        dpPositive[0] = 1;
        dpNegative[0] = 1;
        // assuming no overflow?
        int maxValue = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length+1; i++) {
            if(nums[i-1] < 0) {
                dpNegative[i] = Math.min(dpPositive[i-1] * nums[i-1], nums[i-1]);
                dpPositive[i] = Math.max(dpNegative[i-1] * nums[i-1], nums[i-1]);

                maxValue = Math.max(maxValue, dpPositive[i]);
            } else if (nums[i-1] > 0) {
                // also keep track of the negative value so far
                // up to this point
                dpPositive[i] = Math.max(dpPositive[i-1] * nums[i-1], nums[i-1]);
                dpNegative[i] = Math.min(dpNegative[i-1] * nums[i-1], nums[i-1]);

                maxValue = Math.max(maxValue, dpPositive[i]);
            } else {
                // including this one is definitely 0
                dpPositive[i] = 0;
                dpNegative[i] = 0;
                maxValue = Math.max(maxValue, 0);
            }

        }

        return maxValue;
    }
}
