package Leetcode;

public class L125_ValidPalindrome_E {
    public boolean isPalindrome_v2(String s) {
        if (s == null || s.length() == 0) return true;
        // get rid of non-alphabetical characters
        s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        String r = sb.reverse().toString();
        return r.equals(s);
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while( i< j ) {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            else if (s.charAt(i)!= s.charAt(j)) {
                return false;
            } else{
                i++;
                j--;
            }
        }
        return true;
    }
}
