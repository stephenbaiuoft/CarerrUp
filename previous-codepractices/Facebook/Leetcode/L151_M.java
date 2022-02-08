package Leetcode;

public class L151_M {
    public String reverseWords(String s) {
        if (s == null || s.length() < 1) return s;

        // get rid of white spaces & take care of white space condition
        s = s.trim();
        s = s.replaceAll("\\s+", " ");

        // reverse
        char[] ary = s.toCharArray();
        reverse(ary, 0, ary.length -1);
        int start = 0;
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] == ' ') {
                reverse(ary, start, i-1);
                start = i + 1;
            }
        }

        reverse(ary, start, ary.length -1);

        return String.valueOf(ary);
    }


    // reverse the elements in s given start and end
    private void reverse(char[] s, int start, int end) {
        while(start < end) {
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];
            start ++;
            end--;
        }
    }
}
