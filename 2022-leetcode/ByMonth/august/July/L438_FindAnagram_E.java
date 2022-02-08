package ByMonth.august.July;

import java.util.*;

public class L438_FindAnagram_E {
    public static void main(String[] args) {
        L438_FindAnagram_E p = new L438_FindAnagram_E();
    }

    public L438_FindAnagram_E() {
        String s = "ddcba";
        String p = "abc";

        List<Integer> rez = findAnagramsHashMap(s, p);

    }
    public List<Integer> findAnagramsHashMap(String s, String p) {
        List<Integer> rez = new LinkedList<>();
        // base case
        if (s == null || p == null || s.length() < p.length())
            return rez;

        int countMissing = p.length();
        int l = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i),
                    map.getOrDefault(p.charAt(i), 0) + 1 );
        }

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // restoration
            if ( i>= l ) {
                char leftC = s.charAt(i-l);
                // first, increment 1 for that character
                // leftC is guranteed to exist because we'd always do map.getOrDefault(c, 0) for EVERY CHARACTER
                map.put(leftC, map.get(leftC) + 1);
                // this left out character belongs to missing ones
                if (map.get(leftC) > 0) {
                    countMissing++;
                }
            }

            // look into the map
            if ( map.getOrDefault(c, 0) > 0 ) {
                countMissing --;
            }

            if (countMissing == 0) {
                rez.add(i - l + 1);
            }

            // decrement each character
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        return rez;
    }


    public List<Integer> findAnagramsTest(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (s == null || p == null) return result;

        int missing = p.length();
        char[] sAry = s.toCharArray();

        int[] map = new int[26];
        // init map to track ones we are interested
        // so these chars will > 0, while others are 0
        for (int i = 0; i < p.length(); i++) {
            map[sAry[i] - 'a']++;
        }

        // Now let's iterate through s
        int l = p.length();
        for (int i = 0; i < s.length(); i++) {
            // i >= l, then we can filter out the leftMost char
            // leftMost min is 0, which is what we want
            if (i >= l) {
                int leftMostIndex = i - l;
                // increment that character at leftMostIndex by 1
                // This is because we'd always decrease each character in the map by 1 regardless


                // if it's greater than 0, then it is one of the chars we are interested in
                if (++map[sAry[leftMostIndex] - 'a'] > 0) {
                    missing ++;
                }
            }

            // map[sAray[i] - 'a'] > 0, meaning it's what we want
            if (map[sAry[i] - 'a'] > 0) {
                missing --;
            }

            // if missing is 0, mean we have an anagram now
            if (missing == 0) {
                // put in startIndex
                result.add(i-l+1);
            }

            // when we done with this index i, we decrement that value by 1
            // This is is any character in s
            // This ensures at beginning of the loop,
            // if we ever see map[sAray[i] - 'a'] == 0, then it's what anagram is
            map[sAry[i] - 'a']--;
        }

        return result;

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        if ( s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] map = new int[26];
        // use this map to find anagrams
        int missingCount = 0;
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
            missingCount ++;
        }

        int l = p.length();
        int pCharIndex;
        for (int i = 0; i < s.length(); i++) {
            // put back the previous char count
            if (i >= l) {
                pCharIndex = i - l;
                // increment by 1 first for that pChar
                if (++map[s.charAt(pCharIndex) - 'a'] > 0) {
                    missingCount ++;
                }
            }
            // check whether this is the element we look for
            if (map[s.charAt(i) - 'a'] > 0) {
                missingCount--;
            }

            if (missingCount == 0) {
                // add the starting index
                list.add(i-l+1);
            }

            map[s.charAt(i) - 'a']--;
        }

        return list;

    }
}
