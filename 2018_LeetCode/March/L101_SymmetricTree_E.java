package March;

public class L101_SymmetricTree_E {

    // recursive solution
    // IMPORTANT TO THINK

    // Remember helper function -->
    public boolean isSymmetric(TreeNode root) {
        if(root == null )  return true;
        else {
            return helper(root.left, root.right);
        }
    }

    private boolean helper(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null) return true;
        else if(leftNode != null && rightNode !=null){
            return leftNode.val == rightNode.val
                    && helper(leftNode.right, rightNode.left)
                    && helper(leftNode.left, rightNode.right);
        }
        else{
            // either left is null or right is null
            return false;
        }
    }
}
