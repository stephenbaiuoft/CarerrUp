package Amazon;
/*
*
*
* Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Examples:
    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.
*
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class L387_UniqueNumber_E {
    public int firstUniqChar(String s) {
// if character&& strings use array of 256 max size or even less 26 in this case!
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;

    }
}
