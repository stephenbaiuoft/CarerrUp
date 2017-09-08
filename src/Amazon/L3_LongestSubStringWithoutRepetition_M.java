package Amazon;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */

// idea:
// Dynamic programming
// record every letter it's longest length, then it's next letter can start from that offset
/**
 *        L3_LongestSubStringWithoutRepetition_M program = new L3_LongestSubStringWithoutRepetition_M();
 //System.out.println( program.lengthOfLongestSubstring("abcabcbb") );
 //System.out.println( program.lengthOfLongestSubstring("pwwkew") );
 System.out.println( program.lengthOfLongestSubstring("abba") );
 */

public class L3_LongestSubStringWithoutRepetition_M {

    public int lengthOfLongestSubstring(String s) {

        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
