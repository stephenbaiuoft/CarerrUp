package July;

import java.util.*;

public class L819_MostCommonWord_E {
    public L819_MostCommonWord_E() {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String rez = mostCommonWord(s, new String[] {"hit"});

    }
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() < 1) return null;
        // init the set
//        List<String> tmp = new LinkedList<>();
//        HashSet<String> s1 = new HashSet<>(tmp);

        HashSet<String> set = new HashSet<String>(Arrays.asList(banned));
        // replace the punctuation symbols
        paragraph = paragraph.replaceAll("\\W", " ").toLowerCase();
        // split the string
        String[] rez = paragraph.split(" +");
        HashMap<String, Integer> map = new HashMap<>();
        int max = 1;
        for(String s: rez) {
            // ignore this
            if (set.contains(s)) continue;
            else if (map.containsKey(s)) {
                max = Math.max(map.get(s)+1, max);
                map.put(s, map.get(s)+1);
            } else {
                map.put(s, 1);
            }
        }

        // Map.Entry.comparingByValue()
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

    }
}
