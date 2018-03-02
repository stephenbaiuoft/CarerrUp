package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L139_WordBreak_M {
    public L139_WordBreak_M(){
        String s = "leetcode";
        List<String> wd = new LinkedList<>();
        wd.add("leet");
        wd.add("code");
        wordBreak(s, wd);
    }

    // case when the dictionary is large
    public boolean wordBreak_v2(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            return false;
        }

        // variables
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        // ALWAYS THINK INDEX IN TERMS OF DP INDEX AND
        // WHICH INDEX DOES THE DP Correspond to

        // have j to i, where is the last index of dp
        for(int i = 1; i <= s.length(); i++ ) {
            // use j to navigate through dp and
            // also check for substring
            for (int j = 0; j < i; j++) {
                // make sure j (starting from 1 to N characters) is True
                // AND j'th index is the one right after j character in
                // terms of substring(j, i) SMART!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // case when the dictionary is relatively small
    public boolean wordBreak(String s, List<String> wordDict) {
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
                // make sure if it's true then stay true!
                if (word.length() <= i && !dp[i]){
                    dp[i] = dp[i-word.length()]
                            &&
                            s.substring(i-word.length(), i).equals(word);
                }
            }
        }
        return dp[s.length()];
    }
}
