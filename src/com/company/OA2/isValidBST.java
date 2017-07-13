package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class isValidBST {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
     }

    public boolean isValidBST(TreeNode root) {
            if(root==null) return true;
            return helper(root, Long.MIN_VALUE/2, Long.MAX_VALUE/2);
        }

    public boolean helper(TreeNode n, Long min, Long max){
            if(n == null) return true;
            if( (long) n.val < min || (long)n.val > max){
                return false;
            }
            return  helper(n.left, min, (long)(n.val)-1)&&
                    helper(n.right,(long)n.val+1, max);
        }

}


