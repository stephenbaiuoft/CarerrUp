package ByMonth.august.March;

public class L111_TreeDepthMin_E {
    // understand you have to reach the node!!!!!!
    // # of nodes along the shortest path to the leaf!!!!!!!!!!!!!
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null) return minDepth(root.right) + 1;
        else if (root.right == null) return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        // return the depth + 1
    }
}
