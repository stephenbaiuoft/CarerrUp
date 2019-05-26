package Leetcode;

import java.util.ArrayList;
import java.util.List;

//   https://www.youtube.com/watch?v=2k_rS_u6EBk


public class L301_RemoveInvalidParentheses_H {
    public L301_RemoveInvalidParentheses_H() {
        String t = "()())()";
        removeInvalidParentheses(t);

    }

    private List<String> rez = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for(char c: s.toCharArray()) {
            if (c == '(') left ++;
            if (c == ')') {
                if (left == 0) right++;
                else {
                    left--;
                }
            }
        }
        dfs(s, 0,left, right);

        return rez;
    }


    // DFS the remaining of the str
    // given #_of_leftBrackets AND #_of_rightBrackets to be removed
    private void dfs(String s, int start, int left, int right) {
        if (left == 0 && right == 0  && checkValid(s)) {
            // add to result
            rez.add(s);
            return;
        }
        // loop through rest of the testing.string
        for (int i = start; i < s.length(); i++) {
            // skip duplicates
            if (i != start && s.charAt(i) == s.charAt(i-1)) continue;

            if(s.charAt(i) == ')' && right >0) {
                String s1 = s.substring(0, i) + s.substring(i+1);
                dfs(s1, i, left, right - 1);
            }
            else if (s.charAt(i) == '(' && left >0) {
                String s1 = s.substring(0, i) + s.substring(i+1);
                dfs(s1, i, left -1, right);
            }

        }
    }

    // check if given testing.string is valid
    private boolean checkValid(String s) {
        int count = 0;
        for(char c: s.toCharArray()) {
            if (c == '(') count ++;
            else if (c == ')') count --;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
