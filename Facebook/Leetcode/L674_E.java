package Leetcode;

public class L674_E {
    /*
    * 注意一些 base condition [] or [1] 这样最容易犯错 以及 maxL的init value
    * */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int maxL = 1;
        int l = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                // update l
                l += 1;
                maxL = Math.max(maxL, l);
            }
            // <= smaller or same value
            else {
                // reset l
                l = 1;
            }
        }

        return maxL;
    }
}
