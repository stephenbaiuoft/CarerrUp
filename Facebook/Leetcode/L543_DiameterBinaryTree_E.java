package Leetcode;

public class L543_DiameterBinaryTree_E {
    public int global_max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null )
            return 0;
        countLength(root);
        return global_max;
    }

    // helper function that computes the longest path starting on the node
    public int countLength(TreeNode node) {
        // base condition
        if (node == null ) {
            return 0;
        }
        int left = countLength(node.left);
        int right = countLength(node.right);
        // update global_max
        global_max = Math.max(global_max, left + right );
        // only including left or right path;
        return 1 + Math.max(left, right);

    }
}
