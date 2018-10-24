package ByMonth.august.March;

import java.util.LinkedList;
import java.util.List;

public class L107_BTLevelTraversal_E {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rez = new LinkedList<>();
        // return empty
        if(root == null) return rez;

        // a queue to traverse through the tree structure
        LinkedList<TreeNode> queue = new LinkedList<>();
        // add root
        queue.add(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            int lCount = queue.size();
            List<Integer> l = new LinkedList<>();
            for(int i = 0; i < lCount; i++) {
                // remove from the queue (linkedlist is always head)
                cur = queue.remove();
                l.add(cur.val);
                if(cur.left!=null) {
                    queue.add(cur.left);
                }
                if (cur.right!=null) {
                    queue.add(cur.right);
                }
            }
            // always add @ index 0
            rez.add(0, l);
        }
        return rez;
    }
}
