package Amazon;

/**
 * Given a non-empty testing.string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together.
 * You may assume the given testing.string consists of lowercase English letters only and
 * its length will not exceed 10000.

 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 Example 3:
 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */


public class L459_RepeatedSubStringPattern_M {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) return false;
        int length = s.length();
        for(int i = s.length()/2; i > 0; i--) {

            if(length % i == 0) {
                StringBuilder str = new StringBuilder();
                int count = length / i;
                String substr = s.substring(0, i);
                for(int j = 0; j < count; j++){
                    str.append(substr);
                }
                if(str.toString().equals(s)) return true;
            }
        }
        return false;

    }
}
