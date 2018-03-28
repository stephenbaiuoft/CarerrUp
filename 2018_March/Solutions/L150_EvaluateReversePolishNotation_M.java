package Solutions;

import java.util.Stack;

public class L150_EvaluateReversePolishNotation_M {
    // Stack Structure is the perfect usage here!!!
    public int evalRPN(String[] tokens) {
        // stack and evaluate whenever you see and operator
        Stack<Integer> stack = new Stack<>();
        // always a,b --> assume the token format is correct
        for (int i = 0; i < tokens.length; i++)
        {
            String s = tokens[i];
            if (s.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                // push to stack
                stack.push(b+a);
            }
            else if (s.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            }
            else if (s.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(b*a);
            }
            else if (s.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }
            // value
            else {
                // push the value to stack
                stack.push(Integer.parseInt(s));
            }
        }
        // end result has to be an operator
        return stack.pop();

    }
}
