package Leetcode;

public class L235_LCA_E {

    /*
    * 在bst中 lowestCommonAncestor的property就是  p.val - node.val <=0 && q.val -node.val >=0 or vise versa
    * 所以  product必须要是negative!!!!!!!
    *
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }

    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = q.val < root.val ? root.left : root.right;
        return root;
    }
}
