package twopointers.hashmap.string;

/*
* https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
*
    Given a testing.string s , find the length of the longest substring t  that contains at most 2 distinct characters.

    Example 1:

    Input: "eceba"
    Output: 3
    Explanation: t is "ece" which its length is 3.
    Example 2:

    Input: "ccaabbb"
    Output: 5
    Explanation: t is "aabbb" which its length is 5.
* */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class L159_LongestSubstring_2DistinctChars {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 1) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right++);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // 3
            while(map.size() > 2) {
                char tmp = s.charAt(left++);
                map.put(tmp, map.get(tmp) - 1);
                if (map.get(tmp) == 0) {
                    map.remove(tmp);
                }
            }

            maxLen = Math.max(maxLen, right - left);
        }

        maxLen = Math.max(s.length() - left, maxLen);
        return maxLen;
    }
}
