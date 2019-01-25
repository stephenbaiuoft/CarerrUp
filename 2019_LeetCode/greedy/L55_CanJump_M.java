package greedy;

public class L55_CanJump_M {
    /*
    * Greedy solution
    * 思路就是
    *   curFarest能够 够到到最大到距离， 然后和i对比 只要最大距离比i >=
    *   那么这个就是成立的
    *   O(n) with O(1)
    * */
    public boolean canJump(int[] nums) {
        // dp problem
        // given all integers and we build from smallest to largest
        if (nums == null || nums.length ==0) return false;
        // init
        int curFarest = 0;
        for(int i = 0; i < nums.length; i++) {
            if (i > curFarest){
                return false;
            }
            //update curFarest you can reach
            curFarest = Math.max(curFarest, i + nums[i]);
        }

        return true;
    }

    /*
    * dp就很蠢了 O(n^2)和 O(n)的space 所以 想一想有没有greedy solution可以工作就用greedy
    * */
    public boolean canJumpDp(int[] nums) {
        // dp problem
        // given all integers and we build from smallest to largest
        if (nums == null || nums.length ==0) return false;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break; // break out of the for-loop
                }
            }
        }

        return dp[nums.length-1];
    }
}
