package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102_BTLOT_M {
    public List<List<Integer>> rez = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 0);
        return rez;
    }

    public void traverse(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (rez.size() <= depth) {
            List <Integer> l = new LinkedList<>();
            l.add(node.val);
            rez.add(l);

        }
        else{
            // add the value to the rez list
            rez.get(depth).add(node.val);
        }
        traverse(node.left, depth +1);
        traverse(node.right, depth +1);
    }


    // Another Solution!!!!!
    // Okay this time I'm using a queue to loop-through this example
    public List<List<Integer>> levelOrderQueue(TreeNode root) {
        if(root == null) {
            return new LinkedList<List<Integer>>();
        }

        // queue to store node
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = null;
        List<List<Integer>> rez = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelCount = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < levelCount; i++) {
                // always retrieves the head
                cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right !=null) {
                    queue.offer(cur.right);
                }
            }
            rez.add(list);
        }

        return rez;
    }
}
