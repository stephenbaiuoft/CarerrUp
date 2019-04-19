package stack_array_property;

import java.util.HashMap;
import java.util.Stack;

/*
*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*
* */

//-》 思路用stack + map来存一次需要的index对位置
//   最重要的是用left 和 right来不断的缩小string的范围！！！！！！！ 并且recursion可以update 就很重要
//             for-loop的i的话 问题太大 太麻烦 + offSet以及各种情况 handle起来非常麻烦
// 加油 小白 你可以的！！！！！！！！


public class L394_DecodeString_M {
    public L394_DecodeString_M() {
        String s = "3[a]2[bc]";
        String s1= "3[a2[c]]";
        String rez = decodeString(s);
        System.out.println(rez);
    }

    public String decodeString(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        buildHashMap(map, s);

        return buildStr(s, map, 0, s.length());
    }

    private String buildStr(String s, HashMap<Integer, Integer> map, int left, int right) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(left < right) {
            if (Character.isDigit(s.charAt(left))) {
                num = num*10 + s.charAt(left)-'0'; // add the number
            } else if (map.containsKey(left)) {
                // [inner_str_content_]
                // ith index is (, so i-0+1 elements ahead of the substring
                String rez = buildStr(s, map, left+1, map.get(left)); // new left starting point
                // copy up to num times
                for (int c=0; c<num;c++) {
                    sb.append(rez);
                }

                num = 0; // reset num
                left = map.get(left); // update the new left starting position -> and left++ later
            } else { // it is not [ or ] or number
                // append to sb
                sb.append(s.charAt(left));
            }
            left ++;
        }

        return sb.toString();
    }

    // build hashmap to store first ( and value as its corresponding ) index
    private void buildHashMap(HashMap<Integer, Integer> map, String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(i);
            } else if (s.charAt(i) == ']') {
                // head of stack is ( which matches with first ) you see
                // assuming the string is properly formatted
                map.put(stack.pop(), i);
            }
        }
    }


}
