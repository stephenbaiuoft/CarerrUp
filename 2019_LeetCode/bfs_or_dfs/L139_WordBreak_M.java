package bfs_or_dfs;

/*
* Given a non-empty testing.string s and a dictionary wordDict containing a list of non-empty words,
* determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
* */

import java.util.HashSet;
import java.util.List;

public class L139_WordBreak_M {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() < 1 || wordDict == null || wordDict.size() < 1)
            return false;

        HashSet<String> dic = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        // init dp
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            // always think in terms of dp AND remember the offset!
            for (int j = i; j > 0 ; j-- ) {
                if (dp[j-1] && dic.contains(s.substring(j-1,i))) {
                    dp[i] = true;
                }
            }
        }
        // return whether 1-> s.length() is reachable
        return dp[s.length()];
    }

    public boolean wordBreakSol2(String s, List<String> wordDict) {
        // check base cases
        if (s == null || wordDict == null) return false;
        // init variables
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        // logic --> i is in terms of dp[]
        for(int i = 1; i <= s.length(); i++) {
            // check each word
            for(String word: wordDict) {
                if (word.length() <= i && !dp[i] ){
                    dp[i] = dp[i-word.length()]
                            &&
                            s.substring(i-word.length(), i).equals(word);
                }
            }
        }
        return dp[s.length()];
    }

}
