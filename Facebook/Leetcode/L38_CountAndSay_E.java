package Leetcode;

public class L38_CountAndSay_E {
    public L38_CountAndSay_E() {
        countAndSay(6);
    }

    public String countAndSay(int n) {
        if (n == 0) return "10";
        else if (n < 0) return "";

        String prev = "1";
        for(int i = 2; i <= n ; i++) {
            StringBuilder sb = new StringBuilder();
            String s = prev;
            int count = 1;
            for(int j = 1; j <= s.length(); j++ ) {
                if(j == s.length() || s.charAt(j-1) != s.charAt(j)) {
                    sb.append(count).append(s.charAt(j-1));
                    // reset count
                    count = 1;
                }
                else {
                    // increment count
                    count ++;
                }
            }
            // update prev
            prev = sb.toString();
        }

        return prev;
    }
}
