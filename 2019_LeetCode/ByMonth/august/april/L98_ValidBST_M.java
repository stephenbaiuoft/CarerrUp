package ByMonth.august.april;

public class L98_ValidBST_M {
    // makes more sense using common.data.types.TreeNode!!
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        // check for correct cases when you set the if statement!!!!
        return (min == null || root.val > min.val) && (max == null || root.val < max.val)
                && isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
