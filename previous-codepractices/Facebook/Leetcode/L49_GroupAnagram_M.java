package Leetcode;

import java.util.*;

public class L49_GroupAnagram_M {
    public void test(){
        String[] input = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(input);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rez = new ArrayList<>();
        HashMap<String, List<String> > map = new HashMap<>();
        if (strs == null || strs.length == 0) {
            return rez;
        }

        for(String s: strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            }
            else {
                List <String> l = new ArrayList<>();
                l.add(s);
                map.put(key,  l);
            }
        }

        for ( Map.Entry<String, List<String>> pair: map.entrySet()){
            rez.add(pair.getValue());
        }
        return rez;
    }
}
