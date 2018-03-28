package Solutions;

public class L72_MinDistance_M {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // the dp array
        // dp[m][n] --> the cost to match m_th character with n_th character
        // initially, change dp[i][0] would be i (replacing i characters) and vice versa
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <=m; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <=n; i++) {
            dp[0][i] = i;
        }
        // the dp solution
        for(int i = 1; i <=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    // equal then no need to replace
                    dp[i][j] = dp[i-1][j-1];
                }
                // the other option
                else {
                    // insert a new character to word1, so i matches j-1
                    int c1 = dp[i][j-1];
                    // delete a new character of word1, so i-1 matches j-1
                    int c2 = dp[i-1][j];
                    // replace a new character of word1, so i-1 matches j-1 && i matches j
                    int c3 = dp[i-1][j-1];
                    // and the cost for all 3 is 1
                    dp[i][j] = Math.min(Math.min(c1,c2), c3) + 1;
                }
            }
        }

        return dp[m][n];

    }
}
