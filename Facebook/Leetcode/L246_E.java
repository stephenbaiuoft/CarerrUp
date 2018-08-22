package Leetcode;
/*
*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false

Corner Cases
0 true
2 false

926 true

""
* */

import java.util.HashMap;

public class L246_E {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() < 0) return false;

        int right = num.length() - 1;
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        while (right > -1) {
            char c = num.charAt(right);
            if (!map.containsKey(c)) {
                return false;
            }
            sb.append(map.get(c));
            right -- ;
        }

        return sb.toString().equals(num);

    }
}
