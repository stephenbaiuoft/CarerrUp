package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class BSTPathSum {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public int maxPathSum(TreeNode root) {
        // null means 0
        if (root==null) return 0;

        return root.val + Math.max(maxPathSum(root.left),maxPathSum(root.right));
    }
}
