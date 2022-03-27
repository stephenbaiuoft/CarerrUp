package twopointers.hashmap.string;

import java.util.*;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class L438_Anagram_M {
    // 要点 2 pointer + charMap/inOutFilter + missing
    // right 移动一次 都会自动--
    // left 移动一次 就++ 回来


    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> answer = new LinkedList<>();
        // base checks

        // build map
        int[] inOutFilter = new int[26];
        for (int i = 0; i < p.length(); i++) {
            inOutFilter[getIndex(p.charAt(i))] ++;
        }

        int missing = p.length();
        int n = p.length();
        int left = 0;

        // use right as exploring to the right
        for (int right = 0; right < s.length(); right++) {
            // when we can restore
            if (right >= n) {
                left = right - n;
                if (++inOutFilter[getIndex(s.charAt(left))] > 0) {
                    missing ++;
                }
            }

            if (inOutFilter[getIndex(s.charAt(right))]-- > 0) {
                missing--;
            }

            if (missing == 0) {
                // n length to the right index
                answer.add(right - n + 1);
            }
        }

        return answer;
    }

    private int getIndex(char c) {
        return c - 'a';
    }
}
