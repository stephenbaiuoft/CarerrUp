package ByMonth.august.June;

import java.util.HashMap;

public class L647_PalindromeSubstring_M {
    public L647_PalindromeSubstring_M() {
        String s = "abc";
        int rez = dpSolution(s);
    }

    /*
    * dp的最优解法
    *
    * */
    public int dpSolution(String s) {
        if ( s == null || s.length() < 1) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        // 注意因为dp这里需要用到 i+1 && j - 1 (meaning those indice need to be pre-computed already)
        // --> 所以 i--(这样i+1就有了)  j++（这样j-1， 算是之前的 就有了）
        for(int i = n-1; i > -1; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) )&& ( (j-i <=2) || (dp[i+1][j-1]));
                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public int countSubstrings(String s) {
        if ( s == null || s.length() < 1) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 0;
        for(int i = 1; i < s.length(); i++) {
            count = 0;

            for(int j = 0; j <= i; j++) {
                if (isPalinedrome(s.substring(j, i+1), map)) {
                    count ++;
                }
            }

            dp[i] = dp[i-1] + count;
        }

        return dp[s.length()-1];
    }

    private boolean isPalinedrome(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);

        int left = 0;
        int right = s.length() - 1 ;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                map.put(s, false);
                return false;
            }
            left++;
            right--;
        }

        map.put(s, true);
        return true;
    }
}
