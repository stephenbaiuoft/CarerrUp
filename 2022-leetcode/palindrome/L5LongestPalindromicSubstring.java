package palindrome;

public class L5LongestPalindromicSubstring {
    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     *
     * Input: s = "cbbd"
     * Output: "bb"
     */

    public String longestPalindrome(String s) {
        // step 1 && 2: characterize + dp recursion defnition
        // step 3: 问题是 i + 1 和 j -1 必须prior calculated
        // dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i <=2 || dp[i+1][j-1])

        // Let's so we'd do bottom up ==> How to compute the calculation
        // 思考  i + 1必须存在 所以 i 可以从end to start开始算, 所以i index needs to be from large to small direction)
        // j-1必须存在 所以j index needs to be from small to large direction

        // Sanity check
        if (s == null || s.length() < 1) return "";
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        int low = 0;
        int high = 0;
        int maxLen = 1;

        // n as the last index of s
        int n = s.length() - 1;
        for (int i = n; i > -1; i--) {
            // should j be same as i? ---> Yes because "a" is a palindrome
            for (int j = i; j <=n; j++) {
                dp[i][j] =
                        s.charAt(i) == s.charAt(j)
                                &&
                                // j - i <= 2 means "aa" and "aXa"
                                // OR relationship means
                                // dp[i+1][j-1] means "a SOME_PALINDROME_YEAH a"
                                (j - i <= 2 || dp[i+1][j-1]);

                if (dp[i][j] && j - i + 1 > maxLen ) {
                    maxLen = j - i + 1;
                    low = i;
                    high = j;
                }
            }
        }

        return s.substring(low,high+1);

    }

    public L5LongestPalindromicSubstring() {
        // Run this???
        longestPalindromeTopDown("cbbd");
    }

    // this is Topdown?? --> Yes TopDown is using recursion to find unknown, and your definition of dp is also different
    // Topdown you need to keep state of (visited, True, False) 3 cases in this particualr one
    int[][] dpTable = null;

    public String longestPalindromeTopDown(String s) {
        int n = s.length();
        dpTable = new int [n][n];
        String palinedrome = s.substring(0, 1);
        int max = 1;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if (isPalindrome(s, i, j) && j - i + 1 > max) {
                    max = j - i;
                    palinedrome = s.substring(i, j + 1);
                }
            }
        }
        return palinedrome;
    }

    // -1 nope, 1 yes, 0 not marked
    private Boolean isPalindrome(String s, int i, int j) {

        if (dpTable[i][j] != 0) {
            return dpTable[i][j] == 1;
        } else {
            // base case?
            if ( i == j) {
                dpTable[i][j] = 1;
                return true;
            } else if (i == j - 1) {
                if( s.charAt(i) == s.charAt(j) ){
                    dpTable[i][j] = 1;
                    return true;
                } else{
                    dpTable[i][j] = -1;
                    return false;
                }

            } else {
                if ( s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j -1)  ){
                    dpTable[i][j] = 1;
                    return true;
                } else {
                    dpTable[i][j] = -1;
                    return false;
                }
            }

        }

    }
}
