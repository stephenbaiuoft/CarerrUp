package com.company.DynamicProgramming;

/**
 * Created by stephenbai on 2016-11-15.
 */
public class LongestPalindrome {
    public int [][]indexStorage;
    public int strLen;

    public LongestPalindrome(String input){
        strLen = input.length();
        getString(input);

    }

    public void getString(String input){
        System.out.println(
                dynamicParse(input));

    }




    // return the longest palindrome string
    public String dynamicParse(String s ){
        if (s.length() ==1) return s;

        String longest = s.substring(0,1);
        // always assume start from the centre
        for (int i =0; i < s.length(); i++){
            String tmp = strHelper(i,i,s);
            if (tmp.length() > longest.length()){
                longest = tmp;
            }
            tmp = strHelper(i,i+1, s);
            if (tmp.length() > longest.length()){
                longest = tmp;
            }
        }
        return longest;
    }

    public String strHelper(int i, int j,String str ){
        while( (i>=0) &&(j<=strLen-1) &&
                (str.charAt(i) == str.charAt(j)) ) {
            i--;
            j++;
        }
        // j++, so then j-1; i-- so i +1
        return str.substring(i + 1 , j);
    }


    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }


}


