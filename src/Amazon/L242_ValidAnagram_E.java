package Amazon;


/**
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the testing.string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

// idea:
// int[] ary to count each char in s
// same ary to count char in t, and only decrement if ary[t_char] > 0 or false otherwise

public class L242_ValidAnagram_E {

    public boolean isAnagram(String s, String t) {
        if(s==null || t== null || s.length()!=t.length() ) return false;

        int[] ary = new int[256];

        // iterate and increment each index
        for (char ch: s.toCharArray() ){
            ary[ch] ++;
        }

        for( char ch: t.toCharArray()){
            if(ary[ch] == 0) {
                return false;
            } else{
                ary[ch] --;
            }
        }
        return true;
    }
}
