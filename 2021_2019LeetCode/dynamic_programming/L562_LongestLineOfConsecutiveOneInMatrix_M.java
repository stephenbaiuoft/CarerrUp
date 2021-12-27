package dynamic_programming;

import java.util.Arrays;

public class L562_LongestLineOfConsecutiveOneInMatrix_M {
    public L562_LongestLineOfConsecutiveOneInMatrix_M() {
        int[][] m = new int[3][4];
        m[0] = new int[] {0,1,0,0};
        m[1] = new int[] {0,0,1,0};
        m[2] = new int[] {0,0,0,1};

        int rez = longestLine(m);
    }

    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int l = Math.max(M.length, M[0].length);

        // 0 for horizontal
        // 1 for vertical
        // 2 for left
        // 3 for right diagonal
        int[][] dp = new int[5][l];

        int maxL = 0;
        for (int i = 0; i < M.length; i++) {
            // let prevLeft equal to the currentLeft
            int[] prevLeft = Arrays.copyOf(dp[2], dp[2].length);

            // we don't need to copy prevRight diagonal because of the order we are traversing is
            // from left to right

            for (int j = 0; j < M[0].length; j++) {
                // only case when it is 1 we update DP right
                if (M[i][j] == 1) {
                    // update horizontal
                    if (j-1 < 0) {
                        dp[0][j] = 1;
                    }
                    else {
                        dp[0][j] = dp[0][j-1] + 1;
                    }

                    // update vertical
                    dp[1][j] = dp[1][j] + 1;

                    // update left diagonal
                    if (i - 1 < 0 || j - 1 < 0) {
                        // left diagonal starting point
                        dp[2][j] = 1;
                    } else {
                        dp[2][j] = prevLeft[j-1] + 1;
                    }

                    // update right diagonal
                    if (i-1 < 0 || j + 1 == M[0].length) {
                        dp[3][j] = 1;
                    } else {
                        dp[3][j] = dp[3][j+1] + 1;
                    }
                    // update maxL
                    for (int loop = 0; loop < 4; loop++) {
                        maxL = Math.max(maxL, dp[loop][j]);
                    }
                }
                else { // M[i][j] = 0 then
                    // horizontal needs  to be updated
                    dp[0][j] = 0;

                    // vertical needs to be updated to 0
                    dp[1][j] = 0;

                    // update left vertical
                    dp[2][j] = 0;
                    // update right vertical
                    dp[3][j] = 0;
                }

            }
        }

        return maxL;
    }
}
