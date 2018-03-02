package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L20_ValidParentheses_E {
    public void test() {
        isValid("([)]");
    }
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for( Character c: s.toCharArray()) {

            if ( (c == '}' || c == ')' || c == ']') && !stack.isEmpty()) {
                Character tmp = stack.pop();
                if (tmp != c) {
                    return false;
                }
            }

            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else{
                return false;
            }
        }

        // if empty then yes
        return stack.isEmpty();

    }
}
