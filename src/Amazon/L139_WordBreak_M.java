package Amazon;

import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */


// Dynamic programming? similar to this
public class L139_WordBreak_M {

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] aryRecord = new int[s.length() + 1];
        Arrays.fill(aryRecord, -1);

        aryRecord[0] = 0;
        for(int i = 0; i < s.length(); i ++){
            if(aryRecord[i] != -1){
                for(int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (wordDict.contains(sub)) {
                        aryRecord[j] = i;
                    }
                }
            }
        }

        // last is used to indicate if a subword is contained
        return aryRecord[s.length()] != -1;
    }



}
