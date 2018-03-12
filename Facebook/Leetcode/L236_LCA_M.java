package Leetcode;

public class L236_LCA_M {
    // this is important!!
    // in terms of thinking of recursion!
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // this means the root is the parent
        if (left !=null && right !=null) return root;
        return left == null ? right: left;
    }
}
