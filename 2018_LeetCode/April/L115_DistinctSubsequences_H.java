package April;

public class L115_DistinctSubsequences_H {
    public int numDistinct(String s, String t) {
        if(s == null || t ==null ) return 0;

        int [][] dp = new int[s.length()+1][t.length()+1];
        // default where we know that dp[i][0] = 1 for 0 for t is empty "" string
        for(int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                // case when the character is equal then we know:
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    // # of subsequences are
                    //  i. dp[i-1][j] ==> previous character count
                    //  ii. dp[i-1][j-1] ==> previous character in both two strings
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                } else {
                    // is equal to previous i-1 set
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
