package Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L236_LCA_M {
    private List<TreeNode> mList = new ArrayList<>();

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // think of the base case? or the case where you return
        if (root == null || root == p || root == q){
            return root;
        }
        else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null ){
                return root;
            }

            return left != null ? left : right;
        }



    }


}
