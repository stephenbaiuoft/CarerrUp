package ByMonth.august.March;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Note  --> use list.add(0, val) to reverse the order of the list!!!
//          other things are just trivial BFS
public class L103_ZigZagTraversal_M {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> rez = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) return rez;

        queue.add(root);
        TreeNode cur = null;
        boolean reverse = false;

        while(!queue.isEmpty()) {
            // get level size
            int l = queue.size();

            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < l; i ++) {
                cur = queue.remove();

                if(reverse){
                    list.add(0, cur.val);
                }
                else {
                    list.add(cur.val);
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            // toggle reverse
            reverse = !reverse;
            // add to rez
            rez.add(list);
        }

        return rez;

    }
}
