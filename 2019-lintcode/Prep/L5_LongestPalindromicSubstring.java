package Prep;

public class L5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        int low = 0;
        int high = 0;
        int maxLen = 1;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // dp[i][j] meaning whether s is palindrome
        // dp[i][j] = dp[i+1][j-1] && s.charAt(i)==s.charAt(j)

        for(int i = n-1; i >=0; i--) {
            for(int j = i; j <=n-1; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) &&
                        ( (j-i < 3) || dp[i+1][j-1]) ; // given j-i evaluates first,
                                                       //so dp[i+1][j-1] out of bound would not get executed
                // j-i = 1 && s.charAt(i) == s.charAt(j)  GOOD -> a,a
                // j-1 = 2 && s.charAt(i) == s.charAt(j) GOOD ->a,X,a
                if (dp[i][j]) {
                    if (j-i+1 > maxLen) {
                        maxLen = j - i + 1;
                        low = i;
                        high = j;
                    }
                }

            }
        }

        // return the longest palindrome
        return s.substring(low,high+1);
    }
}
