package Leetcode;

import java.util.Stack;

public class L32_LongestValidParentheses_H {
    public L32_LongestValidParentheses_H() {
        // )()())
        String s = ")()())";
        int r  = longestValidParentheses(s);
        System.out.println(r);
    }

    public int longestValidParentheses(String s) {
    // use a stack to store unmatching indice for '(' and ')'

    if (s == null || s.length() < 1) {
        return 0;
    }
    Stack<Integer> stack= new Stack();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
            stack.push(i);
        }
        // this is the case of )
        else {
            if (stack.isEmpty()) stack.push(i);
            else if( s.charAt(stack.peek()) == '(' ) {
                // remove the index at
                stack.pop();
            }
            else {
                stack.push(i);
            }
        }
    }

    // s stores all the unmatching indices for ( and )
    // we go from right to left
    int right = s.length(), maxLen = 0;

    if (stack.isEmpty()) return s.length();
    while(!stack.isEmpty()) {
        int i = stack.pop();
        maxLen = Math.max(maxLen, right - i - 1);
        // update right
        right = i;
    }
    // last index of right, comparing to the init position startin at 0
    // right - 0 - 1 + 1
    maxLen = Math.max(right, maxLen);

    return maxLen;
}

}
