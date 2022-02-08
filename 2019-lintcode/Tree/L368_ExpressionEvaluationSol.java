package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class L368_ExpressionEvaluationSol {
    int getNodeVal(String sign, Integer base) { // as long as + and - are smaller than * and -
        if (sign.equals("+") || sign.equals("-"))
            return 2 + base;
        if (sign.equals("*") || sign.equals("/"))
            return 4 + base;

        return Integer.MAX_VALUE;
    }

    class TreeNode {
        public int val;
        public String s;
        public TreeNode left, right;

        public TreeNode(int val, String ss) {
            this.val = val;
            this.s = ss;
            this.left = this.right = null;
        }
    }

    // postOrder traversal: left, right, self
    // num1, num2, operator
    void postOrder(TreeNode root, ArrayList<String> list) {
        // base case
        if(root==null)
            return;

        if (root.left != null)
            postOrder(root.left, list);
        if (root.right != null)
            postOrder(root.right, list);
        list.add(root.s);
    }

    public int evaluateExpression(String[] expression) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = null;
        int val = 0;
        Integer base = 0; // this is ensure the order in the Tree with parenthesis

        for (int i = 0; i <= expression.length; i++) {
            if(i != expression.length)
            {
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                }
                if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }
                val = getNodeVal(expression[i], base);
            }

            TreeNode rightNode = i == expression.length ?
                        new TreeNode(Integer.MIN_VALUE, "") :
                        new TreeNode(val, expression[i]);
            while (!stack.isEmpty()) {// build the Tree structure
                if (rightNode.val <= stack.peek().val) {
                    TreeNode curNode = stack.pop();

                    if (stack.isEmpty()) {
                        rightNode.left = curNode;

                    } else {
                        TreeNode left = stack.peek();
                        if (left.val < rightNode.val) {
                            rightNode.left = curNode;
                        } else {
                            left.right = curNode;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(rightNode);
        }

        ArrayList<String> reverse = new ArrayList<String>();
        postOrder(stack.peek().left, reverse);
        String[] str = new String[reverse.size()];
        reverse.toArray(str);

        return reverseEva(str);
    }

    int reverseEva(String[] tokens) {
        int rez = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();

        for (String token : tokens) {
            if (!operators.contains(token)) { // this is a number
                stack.push(token);
            } else { // we evaluate here
                int second = Integer.valueOf(stack.pop());
                int first = Integer.valueOf(stack.pop());
                if (token.equals("+")) {
                    stack.push(String.valueOf(first + second));
                } else if (token.equals("-")) {
                    stack.push(String.valueOf(first - second));
                } else if (token.equals("*")) {
                    stack.push(String.valueOf(first * second));
                } else if (token.equals("/")) {
                    stack.push(String.valueOf(first / second));
                }
            }
        }
        if(stack.isEmpty())
            rez = 0;
        else
            rez = Integer.valueOf(stack.pop());

        return rez;
    }
}
