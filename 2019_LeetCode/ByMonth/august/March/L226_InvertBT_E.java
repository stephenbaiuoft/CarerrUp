package ByMonth.august.March;

public class L226_InvertBT_E {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        // here root is not null, save root.left for now
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
