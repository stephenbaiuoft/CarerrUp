package Amazon;

public class L236_LCA_E {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverseUp(root, p, q);
    }

    // 1. traverse down 2. when traversing backwards (check conditions)
    private TreeNode traverseUp(TreeNode root, TreeNode p, TreeNode q) {
        // base case|return condition: found or not found
        if(root == null || root == p || root == q) {
            return root;
        } else {
            TreeNode left = traverseUp(root.left, p, q);
            TreeNode right = traverseUp(root.right, p, q);
            if(left!=null && right!=null ){
                return root;
            } else {
                return  left !=null ? left : right;
            }
        }
    }
}
