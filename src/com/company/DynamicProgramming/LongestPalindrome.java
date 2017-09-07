package com.company.DynamicProgramming;

/**
 * Created by stephenbai on 2016-11-15.
 */

// Dynamic Programming 2017.07
public class LongestPalindrome {
    private String input;
    public LongestPalindrome(String input){
        if(input!=null){
        this.input = input;
        System.out.println("longest palindrome is: " +  getLongest());
        }

    }

    public String getLongest(){
        int longest = 1;
        String palindrome = this.input.substring(0,1);
        for (int i=0; i < this.input.length(); i++){
            String str1 = centreExpand(i,i);
            String str2 = centreExpand(i,i+1);

            if (str2.length() >=str1.length()
                    && str2.length() > longest
                    ){
                longest = str2.length();
                palindrome = str2;

            }else if (str1.length() > str2.length()
                    && str1.length() > longest
                    ){
                longest = str1.length();
                palindrome = str1;
            }
        }
        return palindrome;
    }

    private String centreExpand(int left, int right){
        while(   right < this.input.length() &&
                left >= 0 &&
                this.input.charAt(left) == this.input.charAt(right)

                ){
            left--;
            right++;
        }
        return this.input.substring(left + 1, right );
    }


}

/* Previous Solutoin
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
*/

