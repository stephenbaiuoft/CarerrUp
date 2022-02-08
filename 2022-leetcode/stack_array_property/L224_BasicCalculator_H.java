package stack_array_property;

import java.util.Stack;

/*
*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

解题思路:  虽然一定是valid 但是不能把parentheses 删除 比如以下
1.    3 - (4-6) 这样的
2. 一般顺序都是stack
3. curVal， sum， sign 3个variable
4. Character.isDigit()

*
* */


public class L224_BasicCalculator_H {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        int curVal = 0;
        int sign = 1;
        char[] set = s.toCharArray();
        for (int i = 0; i < set.length; i++) {
            char cur = set[i];
            if (Character.isDigit(cur)) {
                // adding up the value
                curVal = curVal* 10 + (int) (cur - '0');
            }
            else if (cur == '+') {
                sum += curVal * sign;
                sign = 1;
                curVal = 0;
            }
            else if (cur == '-') {
                sum += curVal * sign;
                sign = -1;
                curVal = 0;
            }
            else if (cur == '(') {
                // store sum, current sign
                stack.push(sum);
                stack.push(sign);
                // resetting curVal ->0 and sign = 1 for calculation within bracket
                sum = 0;
                sign = 1;
            }
            else if (cur == ')') {
                // calculate the sum -> inside this bracket
                sum += sign * curVal;
                sum *= stack.pop();
                // stack.pop() previous sum, and apply to current sum
                sum = stack.pop() + sum;

                // resetting
                sign = 1;
                curVal = 0;
            }
        }

        // last update
        sum = sum + curVal * sign;

        return sum;
    }
}
