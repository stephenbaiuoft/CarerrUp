package August;

import java.util.Arrays;
import java.util.HashMap;

public class L205_E {
    public L205_E() {
        String s = "aa45";
        String t = "ab11";
        boolean rez = isIsomorphic(s, t);
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> rmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (!map.containsKey(sc) ) {
                if (!rmap.containsKey(tc)) {
                    map.put(sc, tc);
                    rmap.put(tc, sc);
                } else {
                    return false;
                }
            } else if (map.get(sc)!= tc) {
                return false;
            }
        }


        return true;
    }
}
