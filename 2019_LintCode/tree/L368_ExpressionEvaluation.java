package tree;

import java.util.Stack;

/*
* For the expression `2*6-(23+7)/(1+2)`,
    Input:
    ["2", "*", "6", "-", "(","23", "+", "7", ")", "/", "(", "1", "+", "2", ")"]

    Output:
    2
* */
public class L368_ExpressionEvaluation {
    public void runTest() {
        String[] input = new String[] {
                "(","(",")",")"
        } ;

        int rez = evaluateExpression(input);
        System.out.println(rez);
    }

    public int evaluateExpression(String[] expression) {
        if (expression == null || expression.length == 0) return 0;
        Stack<Integer> nums = new Stack<>(); // the stack that stores numbers
        Stack<String> ops = new Stack<>(); // the stack that stores operators, will handle ( and )

        String token = null;
        String operator = "+-*/";

        for (int i = 0; i < expression.length; i++) {
            token = expression[i];
            if (operator.indexOf(token) != -1) { // this is an operator of +-*/

                // evalute all the expression that you can evalute
                while (!ops.isEmpty() &&
                        canCalculate(ops.peek(), token)) {
                    nums.push(evaluate(ops.pop(), nums.pop(), nums.pop()));
                }

                // push to ops
                ops.push(token); // push to the ops stack
            }
            else if (token.equals("(")) {
                ops.push(token); // push to ops
            } else if (token.equals(")")) {
                // we need to evaluate now
                while (!ops.peek().equals("(")) {
                    if (!nums.isEmpty()) {
                        nums.push( evaluate (ops.pop(), nums.pop(), nums.pop()) );
                    }
                    else {
                        ops.pop();// poppoing out values
                    }
                }
            }
            else { // not +-*/ or ( or ) --> it is just a number
                nums.push(Integer.parseInt(token));
            }
        }
        if (nums.isEmpty()) return 0;

        while (!ops.isEmpty()) {
            nums.push(evaluate(ops.pop(), nums.pop(), nums.pop()));
        }
        // or pop it
        return nums.peek();
    }

    private boolean canCalculate(String op1, String op2) {
        if (op2.equals("(") || op2.equals(")")) return false;
        if ((op1.equals("*")|| op1.equals("/")) && (op2.equals("+")||op2.equals("-"))) {
            return false;
        }

        return true;
    }

    private int evaluate(String sign, int second, int first) {
        if (sign.equals("+")) {
            return first + second;
        }
        else if (sign.equals("-")) {
            return first - second;
        }
        else if (sign.equals("*")) {
            return first * second;
        }
        else if (sign.equals("/")){
            return first/second;
        } else {
            return 0;
        }
    }
}
