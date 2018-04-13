package March;

import java.util.HashMap;

public class L3_LongestSubstring_M {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        // abba
        for(int i = 0, j = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            // case when the duplicate appears
            //    abcvefgcba
            if (map.containsKey(cur)) {
                j = Math.max(j, map.get(cur) + 1);
                maxCount = Math.max(maxCount, i - j + 1);
                // update cur
                map.put(cur, i);
            } else {
                map.put(cur, i);
                maxCount = Math.max(maxCount, i - j + 1);
            }
        }

        return maxCount;
    }
}
