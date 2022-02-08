package Leetcode;

public class L76_MinWindowSubString_H {
    public L76_MinWindowSubString_H() {
        minWindow("a","b");
    }
    public String minWindow(String s, String t) {
        // base check
        if (s == null || t == null) return s;

        // init variables
        int[] map = new int[128];
        int tracker = t.length();
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        // to move through s
        int end = 0;
        // start is the last starting point
        int start = 0;

        for (char c: t.toCharArray()) {
            map[c] ++;
        }

        // loop through s
        while (end < s.length()) {
            char cur = s.charAt(end);
            // this character is one we still need
            // as it is > 0
            if (map[cur] > 0) {
                // decrement tracker
                tracker --;
            }
            // decrement the corresponding value for
            // the character regardless
            map[cur] --;
            end++;

            // here is the magic
            while(tracker == 0 ){
                if (end - start < minLength){
                    // update minLength & minStart
                    minLength = end - start;
                    minStart = start;
                }
                cur = s.charAt(start);
                // add back
                map[cur]++;
                if (map[cur] > 0) {
                    // means we again lack this character
                    tracker++;
                }
                // increment start
                start++;
            }
        }

        // return "" if not changed or minStart, minStart + offset length
        return minLength == Integer.MAX_VALUE?  "" : s.substring(minStart, minStart + minLength);

    }
}
