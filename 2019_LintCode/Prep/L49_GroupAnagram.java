package Prep;

import java.util.HashMap;
import java.util.*;

public class L49_GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        ArrayList<List<String>> result = new ArrayList<>();
        for (String str: strs) {
            String p = getPattern(str);
            if (!map.containsKey(p)) {
                map.put(p, new ArrayList<>());
            }

            map.get(p).add(str);
        }

        for (List<String> l: map.values()) {
            result.add(l);
        }

        return result;
    }

    private String getPattern(String s) {
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            count[c-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            sb.append(count[i]);
        }

        return sb.toString();
    }
}
