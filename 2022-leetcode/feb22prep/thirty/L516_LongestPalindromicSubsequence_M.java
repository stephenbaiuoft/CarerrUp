package feb22prep.thirty;

public class L516_LongestPalindromicSubsequence_M {
    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {
        // base conditions
        if (s == null || s.length() < 2) return s.length();

        // dp[i][j] as the longest palindromic string in i, j
        // dp[i][j] = if s[i] == s[j] then dp[i+1][j-1] + 2
        //           else max(dp[i][j-1], dp[i+1][j]) because we cant add it

        int[][] dp = new int[s.length()][s.length()];
        // given i+1 needs to be there already, when we do bottom up
        // so i starts from large to small
        int n = s.length();
        for (int i = n -2; i >= 0; i--) {
            // given j-1 needs to be there, so j++ so that j-1 is always known
            for (int j = i; j < n; j++) {
                if (j == i) {
                    // default to be 1,
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                    else if (s.charAt(i) != s.charAt(j)) { // not equal
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }

                }

            }
        }

        // Final result
        return dp[0][s.length()-1];
    }

    public int longestPalindromeSubseqRecursionComplete(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];

        return runDp(0, s.length()-1, dp, s);

    }

    // Complete
    public int runDp(int i, int j, int[][] dp, String s) {
        // Base condition
        if (i >= s.length() || j < 0) return 0;
        // Memorized
        if (dp[i][j] != 0) return dp[i][j];

        // case 1, i = j, so nothing left to find
        if (i == j) {
            dp[i][j] = 1;
            return 1;
        }
        // Only if i < j
        else if (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = runDp(i+1, j -1, dp, s) + 2;
            }
            else {
                dp[i][j] = Math.max(
                        runDp(i+1, j, dp, s),
                        runDp(i, j-1, dp, s));

            }
            // Return the result
            return dp[i][j];
        }
        else { // i > j
            // THIS WILL HAPPEN --> BECAUSE RECURSION will do i+1, and j -1, AND THIS IS IMPORTANT ONLY HANDLED IN THE BASE CONDITION OF RECURSION!!!
            return 0;
        }
    }



    /**
     * 如果你不想考虑i j应该怎么滚轮 那就用memorization 来做
     * @param s
     * @return
     */
    public int longestPalindromeSubseqNoOrder(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];

        char[] charSet = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i ; j < s.length(); j++) {
                getLength(i, j, s, dp);
            }
        }
        return dp[0][s.length()-1];

    }

    // Recursion这里是
    private int getLength(int i, int j, String s, int[][] dp) {
        // memorization
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        else if (i > j) {
            // should not happen here i think?
            return 0;
        }
        else if(i == j) {
            dp[i][j] = 1;
        }
        // case 1
        else if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = getLength(i+1, j -1, s, dp) + 2;
        }
        // case 2
        else {
            dp[i][j] = Math.max(getLength(i+1, j, s, dp),
                    getLength(i, j -1, s, dp));
        }

        return dp[i][j];
    }
}
