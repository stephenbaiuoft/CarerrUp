package feb22prep.thirty;

import java.util.*;

public class L438_FindAnagramsInStr_M {
    //https://leetcode.com/problems/find-all-anagrams-in-a-string/
    /**
     *
     * inOutFilter -> tracks anagram characters count
     *  => This means any character > 0 inOutFilter IS WHAT WE INTERESTED IN!!!
     *
     * Loop through s
     *
     * - when inOutFilter gets out of i - l >= 0 (Restore process)
     *  - Put the count back by + 1
     *  - AND CHECK -> if the result > 0, to see if it's in inOutFilter, where countMissing ++
     *
     * - Each Index, check if it's > 0, so that countMissing can decrease by 1
     * - Now check if countMissing == 0, so that we can add in the (index - l + 1)
     * - Each Index, ALWAYS DECREASE the character for inOutFilter at the end
     *
     * Input: s = "cbaebabacd", p = "abc"
     * Output: [0,6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     */

    public List<Integer> findAnagramsCharMap(String s, String p) {
        List<Integer> rez = new LinkedList<>();
        // base case
        if (s == null || p == null || s.length() < p.length())
            return rez;

        int countMissing = p.length();
        int l = p.length();
        // this controls the status for a given index i
        int[] inOutFilter=  new int[26];
        for(int i = 0; i < p.length(); i++) {
            char cur = p.charAt(i);
            inOutFilter[cur - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Always put back
            if (i - l >= 0) {
                char leftChar = s.charAt(i-l);
                // We can add back now
                // Restore
                inOutFilter[leftChar - 'a']++;
                // But maintain countMissing
                if (inOutFilter[leftChar -'a'] > 0) {
                    countMissing ++;
                }
            }

            // For current index
            if (inOutFilter[c - 'a'] > 0) {
                // We found a character in anagram
                countMissing--;
            }

            if (countMissing ==0) {
                rez.add(i - l + 1);
            }

            // Decrease by default
            inOutFilter[c - 'a']--;
        }

        return rez;

    }


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rez = new LinkedList<>();
        // base case
        if (s == null || p == null || s.length() < p.length())
            return rez;

        int countMissing = p.length();
        int l = p.length();
        // this controls the status for a given index i
        HashMap<Character, Integer> inOutCount = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            inOutCount.put(p.charAt(i),
                    inOutCount.getOrDefault(p.charAt(i), 0) + 1 );
        }

        // Key is we decrease per character seen at i within the l length
        //  --> we add back when it's out of the l scope
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (i - l >=0) {
                char leftC = s.charAt(i-l);
                // We now add get
                inOutCount.put(leftC, inOutCount.get(leftC) + 1);
                // Within the filter, anything is what we missing
                if (inOutCount.get(leftC) > 0) {
                    countMissing ++;
                }
            }

            // for every index
            // Either found && it's what we miss
            // - or not found, which we don't care, so set to 0
            if (inOutCount.getOrDefault(cur, 0) > 0) {
                countMissing --;
            }

            if (countMissing == 0) {
                // this is a matching index
                // This is the l offset lol
                rez.add(i - l + 1);
            }

            // We always decrease by one
            inOutCount.put(s.charAt(i), inOutCount.getOrDefault(s.charAt(i), 0) - 1);
        }

        return rez;
    }
}
