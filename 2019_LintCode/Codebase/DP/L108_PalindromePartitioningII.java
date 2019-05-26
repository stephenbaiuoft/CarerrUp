package Codebase.DP;


/*
*
Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:

Input: "a"
Output: 0
Explanation: "a" is already a palindrome, no need to split.

*
* */

public class L108_PalindromePartitioningII {
    private boolean[][] buildPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) { //itself
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) { // length of 1 for all possible indices
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) { // length starting from 2  until the length of s.length()
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                        = isPalindrome[start + 1][start + length - 1] &&
                            s.charAt(start) == s.charAt(start + length); // expanding out
            }
        }

        return isPalindrome;
    }

    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        boolean[][] isPalindrome = buildPalindrome(s);

        int[] dp = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = i; // max worst case scenario
            for (int start = 0; start < i; start++) { // [start,i-1] --> in string s [start,i]
                if (isPalindrome[start][i - 1]) { // default palindrome --> +1
                    dp[i] = Math.min(dp[i], dp[start] + 1);
                }
            }
        }

        return dp[s.length()] - 1; // offset for itself being a palindrome
    }
}
