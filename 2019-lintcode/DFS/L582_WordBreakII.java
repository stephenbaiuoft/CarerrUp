package DFS;

import java.util.*;

public class L582_WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {

        Map<String, ArrayList<String>> dp = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s, wordDict, dp);
    }

    // return an array of substring that would build up the string, s,
    public ArrayList<String> wordBreakHelper(String s,
                                             Set<String> dict,
                                             Map<String, ArrayList<String>> dp){
        // base case
        if (dp.containsKey(s)){
            return dp.get(s);
        }

        ArrayList<String> path = new ArrayList<String>();
        if (s.length() == 0) {
            return path;
        }
        // part of the dict, s exists
        if (dict.contains(s)) {
            path.add(s);
        }

        for (int len = 1; len < s.length(); len++){
            String word = s.substring(0, len);
            if (!dict.contains(word)) {
                continue;
            }

            String suffix = s.substring(len);
            ArrayList<String> suffixPathSet = wordBreakHelper(suffix, dict, dp);

            // add to the current path for each possbile suffix path
            for (String segmentation: suffixPathSet){
                path.add(word + " " + segmentation);
            }
        }

        dp.put(s, path);
        return path;
    }
}
