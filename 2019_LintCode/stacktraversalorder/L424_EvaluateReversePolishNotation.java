package stacktraversalorder;

import java.util.Stack;

//注意 token给你的逻辑顺序就好了
// 因为没有()就简单很多
public class L424_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // write your code here
        String cal= "+-*/";
        Stack<Integer> value = new Stack<>();
        for (String s: tokens) {
            if (cal.indexOf(s) == -1) {
                value.push(Integer.valueOf(s)); // safely push to stack
            } else { // we need to calculate
                int v2 = value.pop();
                int v1 = value.pop();
                if (s.equals("+")) {
                    value.push(v1+v2);
                }
                else if (s.equals("-")) {
                    value.push(v1-v2);
                }
                else if (s.equals("*")) {
                    value.push(v1*v2);
                }
                else {
                    value.push(v1/v2);
                }
            }
        }

        // should be last element
        return value.pop();
    }
}
