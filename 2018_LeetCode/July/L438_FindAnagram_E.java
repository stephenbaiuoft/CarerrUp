package July;

import java.util.*;

public class L438_FindAnagram_E {
    public L438_FindAnagram_E() {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> rez = findAnagrams(s, p);

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
        for (int i = 0; i < s.length(); i++) {
            // put back the previous char count
            if ((i >= l) && (++map[s.charAt(i-l) - 'a'] > 0)) {
                missingCount ++;
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
