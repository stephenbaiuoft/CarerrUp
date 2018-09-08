package Leetcode;

public class L678_E_M {

    private int gMax = 0;

    // return the longest length up to root
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;

        // initially --> make sure the root.val is not found
        longestPathFromNode(root, root.val - 1);
        return gMax;
    }

    // this recursion
    // 1.--> you must include this node
    // 2.--> you ONLY increment IFF prevValue equals to this node's value
    private int longestPathFromNode(TreeNode node, int preValue) {
        if (node == null) return 0;
        // Check this out: you now put the node.val to the next recursion!!!!
        int left = longestPathFromNode(node.left, node.val);
        int right = longestPathFromNode(node.right, node.val);
        int count = 0;

        // NOTE: left means that the longestPath with values equals to current node.val
        //       similarly for right
        // so gMax can be safely derived this way
        gMax = Math.max(gMax, left + right);

        // Trick for returning the value!!!
        // WE ONLY RETURN 1 PATH to AVOID Y shape!
        if (node.val == preValue) {
            count = 1 + Math.max(left, right);
        }

        // No Need -> because the previous comparison: gMax = Math.max(gMax, left +right);
        // So -> gMax = Math.max( c, gMax); is not required ANY MORE!!!!!!!!
        return count;
    }

}
