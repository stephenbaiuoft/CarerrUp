package Codebase.DP;

/*
*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).


The function prototype should be:

bool isMatch(string s, string p)

* */

public class L154_RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        // write your code here
        if (p == null || p.length() == 0)
            return (s == null || s.length() == 0);
        // let's iterate on s with pattern incrementing
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        // p = "" 和 s = "" 一定是true
        dp[0][0] = true;

        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        for (int pi = 2; pi <= p.length(); pi++) {
            // 相当于 a*c*b* 是一个空的string的init condition
            dp[pi][0] = pArray[pi - 1] == '*' && dp[pi - 2][0];
        }

        // 相当于每一次loop 都是以 pattern increment by 1 为准！ 很重要
        for (int pi = 1; pi <= p.length(); pi++) {
            for (int si = 1; si <= s.length(); si++) {
                //第一种最简单, p的此个loop的character 与 s当前相同
                // 这个就取决于之前的每一个的状态
                if (pArray[pi - 1] == sArray[si - 1] || pArray[pi - 1] == '.') {
                    dp[pi][si] = dp[pi - 1][si - 1];
                }
                // 第二个情况就是 p当前是 * 那么， s来match这个就会有很多情况
                else if (pArray[pi - 1] == '*') {
                    //第一种就是 * 为0个作为考虑, 那么就是 pattern previous2个的地方
                    dp[pi][si] = dp[pi - 2][si] ||
                            //第二种就是 * >=1  个重复,
                            // - 比如 <<<a*(*等于1) vs a >>>，
                            // - 比如 <<<a*(*等于2) vs aa >>>
                            // 所以相当于 s 这个string的上一个index 和 当前此pattern的 p相对比!!! 当前很重要！
                            // DP[pi][si-1] 太重要了 因为 1个或者多个(>=2)一定是 在forloop中构造出来的
                            // 而且是------> s一直在和p在match 就非常重要
                            // 你想 如果是* = 1个就是s的previous *=2个， 在loop中 还是s的previous
                            (dp[pi][si - 1] &&
                                    (pArray[pi - 2] == sArray[si - 1] || pArray[pi - 2] == '.')
                            );
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
