package Leetcode;


/*

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true

 *
 */
// --> DP problem: note the index offset when traversing through the string
//     literal as
public class L10_RegularExpression_H {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 2; i <= n; i++){
            if(pc[i - 1] == '*'){
                dp[0][i] = dp[0][i - 2]; // *可以消掉c*
            }
        }

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j++){
                if(sc[i - 1] == pc[j - 1] || pc[j - 1] == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pc[j - 1] == '*'){
                    if(sc[i - 1] == pc[j - 2] || pc[j - 2] == '.'){
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                        // 当*的前一位是'.'， 或者前一位的pc等于sc的话，
                        // *代表1个(dp[i][j - 1])，*代表多个(dp[i - 1][j])，
                        // 或者用*消掉c*(dp[i][j - 2])
                    } else {
                        dp[i][j] = dp[i][j - 2]; // 用*消掉c*
                    }
                }
            }
        }

        return dp[m][n];
    }

}
