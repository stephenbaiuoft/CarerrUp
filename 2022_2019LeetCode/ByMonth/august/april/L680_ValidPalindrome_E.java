package ByMonth.august.april;

public class L680_ValidPalindrome_E {
    public L680_ValidPalindrome_E() {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        boolean rez =  validPalindrome(s);

        String t =
                "lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul";
    }

    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length()-1;
        boolean deleted = false;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
            }
            // advance the pointer
            left ++;
            right --;
        }

        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while(l<r) {
            if(s.charAt(l)!= s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
