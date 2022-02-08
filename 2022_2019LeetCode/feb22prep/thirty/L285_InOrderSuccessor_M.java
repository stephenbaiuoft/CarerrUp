package feb22prep.thirty;

public class L285_InOrderSuccessor_M {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // base case
        if(root == null) return null;

        else if (root.val <= p.val) {
            // must be in root right subtree
            return inorderSuccessor(root.right, p);
        }
        // other case
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            // need to return the root where the first null is hit
            // when backtracking to this level, this will be
            // the node
            if (left == null) {
                // case where the parent is being returned
                return root;
            }
            else {
                // now as for others return the left, which is the parent node
                return left;
            }
        }
    }

}
