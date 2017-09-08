package Amazon;

/**
 * Created by stephen on 7/20/17.
 */
/**
 *Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.

 //Idea: BST: left has to be smaller than root, right has to be greater than root
 */



public class L98_ValidBST_E {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Long.MIN_VALUE/2, Long.MAX_VALUE/2);
    }


    private boolean isValidNode(TreeNode node, long minVal, long maxVal) {
        if(node == null) return true;

        if(node.val >= maxVal || node.val <= minVal) return false;

        return isValidNode(node.left, minVal, node.val)
                &&
                isValidNode(node.right, node.val,
                        maxVal);
    }
}
