package ByMonth.august.april;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class L314_VerticalOrder_M {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();
        LinkedList<List<Integer>> rez = new LinkedList<>();

        if(root == null) return rez;
        bfsTree(root, tMap);

        // read from tMap based on the colRanking
        while(!tMap.isEmpty()) {
            // pollFirstEntry (smallest first --> larger ones)
            List<Integer> l = tMap.pollFirstEntry().getValue();
            rez.add(l);
        }

        return rez;
    }

    // priviate function that will traverse the tree (note node is the root)
    // based on the colRank system, where to the left is -1, and to the right is +1
    // treemap is used s.t vertical col order is maintained  ==> (the col rank)
    private void bfsTree(TreeNode node, TreeMap<Integer, List<Integer>> tMap) {
        // qNode to keep track of Node
        Queue<TreeNode> qNode = new LinkedList<>();
        // qCol to keep track of Col rank (as long as insertion order is maintained)
        // the queue node and queue col order will be maintained
        Queue<Integer> qCol = new LinkedList<>();

        // root and 0 as the base condition
        qNode.add(node);
        qCol.add(0);

        while(!qNode.isEmpty()) {
            TreeNode cur = qNode.poll();
            int colRank = qCol.poll();
            if (!tMap.containsKey(colRank)) {
                List<Integer> list = new LinkedList<>();
                tMap.put(colRank, list);
            }
            tMap.get(colRank).add(cur.val);

            if (cur.left !=null) {
                qNode.add(cur.left);
                qCol.add(colRank-1);
            }
            if (cur.right !=null) {
                qNode.add(cur.right);
                qCol.add(colRank + 1);
            }

        }

    }
}
