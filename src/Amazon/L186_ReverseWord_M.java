package Amazon;

import java.util.regex.Pattern;

/**
 Question:
 Given an input testing.string, reverse the testing.string word by word.
 A word is defined as a sequence of non-space characters.

 The input testing.string does not contain leading or trailing spaces
 and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 */

// idea: reverse testing.string and reverse each word!
public class L186_ReverseWord_M {
    public String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll(" +", " ");
        // reverse the testing.string first
        char[] revChars = reverse(s.toCharArray(), 0, s.length()- 1);

        int wordStart = 0;
        for(int i = 0; i < revChars.length; i++){
            if(revChars[i] == ' ' ){
                reverse(revChars, wordStart, i -1);
                wordStart = i + 1;
            }
        }
        // the last one
        reverse(revChars, wordStart, revChars.length - 1);
        return String.valueOf(revChars);
    }

    private char[] reverse(char[] ary, int start, int end){
        while(start < end){
            ary[start] ^= ary[end];
            ary[end] ^= ary[start];
            ary[start] ^= ary[end];
            start ++;
            end--;
        }

        return ary;
    }

}
