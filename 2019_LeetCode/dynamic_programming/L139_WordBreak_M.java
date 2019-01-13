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

        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        int l = wordDict.get(0).length();
        int h = l;
        for (String word: wordDict) {
            // [l, h] --> the search range
            l = Math.min(l, word.length());
            h = Math.max(h, word.length());
        }

        for (int i = 1; i <= s.length(); i++) {
            if (i >= l) {
                // only search within the range of [i-h, i-l]
                for (int j = i - h + 1< 1? 1: i-h+1; j <= i-l + 1; j++ ) {
                    // j is in terms of the substring inclusively
                    // so the substring including j-1, i
                    if (dp[j-1] && set.contains(s.substring(j-1, i))) {
                        dp[i] = true;
                        break;// true already
                    }
                }
            }
        }

        return dp[s.length()];
    }

}
