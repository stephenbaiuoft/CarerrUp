package dp;

import java.util.Arrays;

public class LongestIncreasingSequence {
    public LongestIncreasingSequence() {
        int[] A = new int[] {1, 3, 5};
        int r = lis(A);
    }

    public int lis( int[] A) {
        if (A == null || A.length < 1) return 0;
        int[] dp = new int[A.length];
        Arrays.fill(dp, 1);
        int maxVal = 1;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }

        return maxVal;

    }
}
