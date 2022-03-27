package dp;

/*
* Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".


思路是！！！ 注意 2d的走向！  一定是 pattern 一个一个increment， 然后 每一次p的increment， s就是一整个loop！ 这个顺序太tm重要了

* */
public class L10_RegularExpression_H {
    public static void main(String[] args) {
        L10_RegularExpression_H p = new L10_RegularExpression_H();
        p.isMatch("c", "a*c");
    }

    public boolean isMatch(String s, String p) {
        // given string, dp[0][0] = true -> always a match
        // dp[i][j] is match where i is s[0, i], p[0,j]
        // dp[i][j] =
        // 1. ((p[j-1] == '.')|| (p[j-1] == s[i-1]) ) && dp[i-1][j-1]
        // 2. (p[j-1] == '*') && (dp[some_i][j-1] )
        // * zero or more dp[i~0] needs to be set as inner loop
        // you have flip it
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();

        // when you given a*b*c*
        // 因为dp[2][0] dp[4][0] = true if p like is "a*b*c*" vs s being "d"
        for(int pi = 2; pi <= m; pi++) {
            if (pa[pi - 1] == '*') {
                dp[pi][0] = dp[pi-2][0];
            }
        }

        // outer loop is p
        // inner loop is s
        for (int j = 1; j < m+1; j++) {
            for (int i = 1; i < n+1; i++) {
                if ((pa[j-1] == '.') || pa[j-1] == sa[i-1]) {
                    dp[j][i] = dp[j-1][i-1];
                }
                else if (pa[j-1] == '*') {
                    // j-2 to skip j-1 as * is 0 or more
                    // (.*, a*) count as 0,
                    // (.*, a*) count as at least 1
                    dp[j][i] =  dp[j-1][i-1] || dp[j-2][i] || dp[j-1][i-1];
                }
            }
        }

        return dp[m][n];
    }


//    public boolean isMatch(String s, String p) {
//        if (p == null || p.length() == 0)
//            return (s == null || s.length() == 0);
//        // let's iterate on s with pattern incrementing
//        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
//        // p = "" 和 s = "" 一定是true
//        dp[0][0] = true;
//
//        char[] sArray = s.toCharArray();
//        char[] pArray = p.toCharArray();
//        for (int pi = 2; pi <= p.length(); pi++) {
//            // 相当于 a*c*b* 是一个空的string的init condition
//            dp[pi][0] = pArray[pi - 1] == '*' && dp[pi - 2][0];
//        }
//
//        // 相当于每一次loop 都是以 pattern increment by 1 为准！ 很重要
//        for (int pi = 1; pi <= p.length(); pi++) {
//            for (int si = 1; si <= s.length(); si++) {
//                //第一种最简单, p的此个loop的character 与 s当前相同
//                // 这个就取决于之前的每一个的状态
//                if (pArray[pi - 1] == sArray[si - 1] || pArray[pi - 1] == '.') {
//                    dp[pi][si] = dp[pi - 1][si - 1];
//                }
//                // 第二个情况就是 p当前是 * 那么， s来match这个就会有很多情况
//                else if (pArray[pi - 1] == '*') {
//                    //第一种就是 * 为0个作为考虑, 那么就是 pattern previous2个的地方
//                    dp[pi][si] = dp[pi - 2][si] ||
//                            //第二种就是 * >=1  个重复,
//                            // - 比如 <<<a*(*等于1) vs a >>>，
//                            // - 比如 <<<a*(*等于2) vs aa >>>
//                            // 所以相当于 s 这个string的上一个index 和 当前此pattern的 p相对比!!! 当前很重要！
//                            // DP[pi][si-1] 太重要了 因为 1个或者多个(>=2)一定是 在forloop中构造出来的
//                            // 而且是------> s一直在和p在match 就非常重要
//                            // 你想 如果是* = 1个就是s的previous *=2个， 在loop中 还是s的previous
//                            (dp[pi][si - 1] &&
//                                    (pArray[pi - 2] == sArray[si - 1] || pArray[pi - 2] == '.')
//                            );
//                }
//            }
//        }m
//        return dp[p.length()][s.length()];
//    }
}
