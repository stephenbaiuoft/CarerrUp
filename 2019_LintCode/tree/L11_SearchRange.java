package tree;

import common.data.types.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class L11_SearchRange {
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> l = new LinkedList<>();
        traverse(root, k1, k2, l);

        return l;
    }

    private void traverse(TreeNode root, int k1, int k2, List<Integer> l) {
        if (root == null) return;
        if (root.val > k1) { // search the possible range ONLY
            traverse(root.left, k1, k2, l);
        }

        if (root.val >=k1 && root.val <=k2) {
            l.add(root.val);
        }

        if (root.val < k2) {
            traverse(root.right, k1,k2,l);
        }

    }

}
