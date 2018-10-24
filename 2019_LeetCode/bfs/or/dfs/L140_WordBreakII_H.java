package bfs.or.dfs;

import java.util.*;

/*
* Given a non-empty testing.string s and a dictionary wordDict containing a list
 * of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
* */
public class L140_WordBreakII_H {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(s.length() == 0 || wordDict.size() == 0) return result;
        Set<String> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE, minLen = Integer.MAX_VALUE;
        for(String str : wordDict){
            set.add(str);
            maxLen = Math.max(maxLen, str.length());
            minLen = Math.min(minLen, str.length());
        }
        wordBreakHelper(result, set, new boolean[s.length()], new StringBuilder(), s, maxLen, minLen, 0);
        return result;
    }

    public boolean wordBreakHelper(List<String> result, Set<String> set, boolean[] dead, StringBuilder sb,
                                   String s, int maxLen, int minLen, int start){
        if(start == s.length()){
            result.add(sb.toString().trim());
            return true;
        }
        if(dead[start]) return false;
        boolean success = false;
        for(int i = start + minLen - 1; i < Math.min(start + maxLen, s.length()); i++){
            String sub = s.substring(start, i + 1);
            if(set.contains(sub)){
                int sbLen = sb.length();
                sb.append(sub).append(' ');
                if(wordBreakHelper(result, set, dead, sb, s, maxLen, minLen, i + 1)) success = true;
                sb.setLength(sbLen);
            }
        }
        dead[start] = !success;
        return success;
    }

}


/*
* Working Solution Without Memorizaiton (TL)
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> rez = new LinkedList<>();
        HashSet<String> set = new HashSet<String>();
        int minStart = 0;
        int maxEnd = 0;
        for (String word: wordDict) {
            minStart = Math.min(minStart, word.length());
            maxEnd = Math.max(maxEnd, word.length());
            set.add(word);
        }

        explore(rez, s, "", set, minStart, maxEnd, 0);
        return rez;
    }

    // dfs
    private void explore(List<String> rez, String s, String curString,
                         HashSet<String> set, int minStart, int maxEnd, int sIndex) {
        // base condition
        if (sIndex == s.length()) {
            rez.add(curString.trim());
            return;
        }

        // Choose, explore, unchose
        for (int i = sIndex + minStart; i <= Math.min(s.length(),i + maxEnd);  i++) {
            // if we found a match word
            String curWord = s.substring(sIndex, i);
            if (set.contains(curWord)) {
                explore(rez, s, curString + curWord + " ",
                        set, minStart, maxEnd, i);
            }
        }
    }
* */