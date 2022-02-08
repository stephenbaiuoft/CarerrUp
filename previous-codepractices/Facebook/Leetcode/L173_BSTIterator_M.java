package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class L173_BSTIterator_M {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    Stack<TreeNode> stack =  null ;
    TreeNode current = null ;

    public void BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<> ();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left ;
        }
        TreeNode t = stack.pop() ;
        current = t.right ;
        return t.val ;
    }
}
