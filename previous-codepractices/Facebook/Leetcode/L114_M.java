package Leetcode;

import java.util.*;

public class L114_M {
    // 用一个global的prev来存每一次recursion的信息
    private TreeNode prev = null;
    public void flatten_recur(TreeNode root){
        if (root == null) return;
        flatten_recur(root.right);
        flatten_recur(root.left);

        //这里做一个link
        root.right = prev;
        // 左边的指向null 因为上一步 flattern已经 (root.left) 了
        root.left = null;
        prev = root;
    }

    // Iterative Approach
    public void flatten_itr(TreeNode root) {
        // preOrder the iterative
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = new TreeNode(0);
        TreeNode cur = null;
        if (root != null) {
            stack.push(root);
        }

        while(!stack.isEmpty()) {
            cur = stack.pop();
            // update prev.right and prev correspondingly
            prev.right = cur;
            prev = prev.right;

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
                // update cur.left
                cur.left = null;
            }

        }

    }
}
