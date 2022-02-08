package Leetcode;

public class L28_strStr_E {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {return -1;}

        // if subString --> + 1 because you wanno start @ after that position
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for(int j =0; ; j++) {
                // case when
                if (j == needle.length()) return i;
                else if (i + j == haystack.length()) return -1;
                // not equal case
                else if (needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }

        return -1;
    }

}
