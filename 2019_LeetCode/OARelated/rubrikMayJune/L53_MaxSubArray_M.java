package OARelated.rubrikMayJune;

public class L53_MaxSubArray_M {
    public L53_MaxSubArray_M() {
        int[] input = new int[] {
            -2,1,-3,4,-1,2,1,-5,4
        };

        int rez = maxSubArray(input);

    }

    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length+1];
        dp[1] = nums[0];
        int maxVal = Integer.MIN_VALUE;

        for(int i = 2 ; i <= nums.length; i++) {
            // always check whether which one contains more
            // as this is continuous array
            dp[i] = Math.max(dp[i-1] + nums[i-1], nums[i-1]);
            maxVal = Math.max(dp[i], maxVal);
        }

        return maxVal;
    }
}
