package string.processing;

import java.util.ArrayList;
import java.util.List;

public class L524_LongestWordInDicThroughDeleting_M {
    public L524_LongestWordInDicThroughDeleting_M() {
        List<String> d = new ArrayList<>();
        d.add("foo");
        d.add("bar");
        String rez = findLongestWord("foobarfoobar", d);
    }

    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0
                || d == null || d.size() == 0) return "";

        String rez = "";
        for (String w: d) {
            if (contains(s, w)) {
                if (w.length() > rez.length()) {
                    //
                    rez = w;
                } else if (w.length() == rez.length() &&
                        w.compareTo(rez) < 0) {
                    rez = w;
                }
            }
        }

        return rez;
    }

    private boolean containsForLoop(String s, String w) {
        if (w.length() > s.length()) return false;

        int wi = 0;
        // for-loop to loop through s, which makes sense!!!!!
        for (int i = 0; i < s.length() && wi < w.length(); i++) {
            if (s.charAt(i) == w.charAt(wi)) {
                wi++;
            }
        }

        return wi == w.length();
    }


    // return whether w is in s by removing from s
    private boolean contains(String s, String w) {
        if (w.length() > s.length()) return false;
        int si = 0;
        int wi = 0;

        // while-loop to check for every condition
        while (si < s.length() && wi < w.length()) {
            if (s.charAt(si) != w.charAt(wi)) {
                // not equal increment si to next character
                si++;
            } else { // s.charAt(si) == w.charAt(wi)
                // increment wi
                // increment si as well!!!这很重要便宜
                si++;
                wi++;
            }
        }

        return wi == w.length(); // if successful then wi would be incremented
    }
}
