package ByMonth.august.July;
import java.util.*;

public class L76_MinString_H {
    public L76_MinString_H() {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String rez = minWindow(s, t);
    }

    public String minWindow(String s, String t) {
        if(s == null || t == null) return "";
        int start = 0, end = 0, minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int missingCount = t.length();

        int[] map = new int[256];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) ] ++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]-- > 0) {
                missingCount --;
            }

            // increment end to 1 to the right
            end++;
            while (missingCount == 0) {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                }
                // add first, the start index character back
                // then increment the start index
                if ( ++map[s.charAt(start++)] > 0) {
                    missingCount++;
                }
            }
        }

        return minLength == Integer.MAX_VALUE? "": s.substring(minStart, minStart + minLength);

    }

}
