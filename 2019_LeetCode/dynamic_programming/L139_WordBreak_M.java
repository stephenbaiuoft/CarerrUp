package dynamic_programming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L139_WordBreak_M {
    public L139_WordBreak_M() {
        String s = "applepenapple";
        List<String> l = new LinkedList<>();
        l.add("apple");
        l.add("pen");

        boolean v = wordBreakSol2(s, l);
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

    public boolean wordBreakWithOptimization(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0) return false;
        // build the dic
        HashSet<String> map = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        int l = wordDict.get(0).length();
        int h = l;
        for (String word: wordDict) {
            // [l, h] --> the search range
            l = Math.min(l, word.length());
            h = Math.max(h, word.length());
        }

        for (int i = l; i <= s.length(); i++) {
            // only search within the range of [i-h, i-l]
            for (int j = i - h + 1< 1? 1: i-h+1; j <= i-l + 1; j++ ) {
                // j is in terms of the substring inclusively
                // so the substring including j-1, i
                if (!dp[i]) {
                    dp[i] = dp[j-1] && map.contains(s.substring(j-1, i));
                }
            }

        }

        return dp[s.length()];
    }

    // 最basic的解法 你考虑一下！
    public boolean wordBreakDefault(String s, List<String> wordDict) {
        // build the dic
        HashSet<String> map = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // j also refers to the dp index

            // j <= i 因为你需要考虑 len=1的情况 ==> dp[0] && s.substring(0,1) == "a"
            for (int j = 1; j <= i; j++) {
                if (!dp[i]) {
                    dp[i] = dp[j-1] && map.contains(s.substring(j-1,i));
                }
            }
        }

        return dp[s.length()];
    }
}
