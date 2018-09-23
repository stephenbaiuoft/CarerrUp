package Leetcode;

public class L561_M {
    public L561_M() {
        String s1 = "";
        String s2 = "";
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1 ==null || s2 == null || s1.length() < s2.length()) return false;
        int[] map = new int[256];
        int countMissing = s1.length();
        int l = s1.length();
        // construct map
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            // restore previous characters
            if (i >= l && ++map[s2.charAt(i-l) - 'a'] > 0) {
                countMissing ++;
            }
            // whether this character is the one you look for
            if (map[c-'a']-- > 0) {
                System.out.println(c);
                countMissing--;
            }
            if (countMissing == 0) {
                return true;
            }
        }

        return false;

    }

}
