package ByMonth.august.March;

public class L617_MergeTwoBST_E {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // create the node
        TreeNode node = new TreeNode(0);

        if(t1 == null && t2 == null) {
            return null;
        }
        else if(t1 == null) {
            node.val  = t2.val;
        } else if(t2 == null) {
            node.val = t1.val;
        } else {
            node.val = t1.val + t2.val;
        }

        node.left = mergeTrees(t1 == null? null: t1.left, t2== null ? null: t2.left);
        node.right = mergeTrees(t1 == null? null: t1.right, t2 == null? null: t2.right);

        return node;
    }
}
