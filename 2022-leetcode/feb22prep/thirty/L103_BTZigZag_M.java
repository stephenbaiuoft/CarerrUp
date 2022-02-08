package feb22prep.thirty;

import java.util.*;

public class L103_BTZigZag_M {

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

    /**
     * BFS
     * -> 1 每一层 level 需要一个counter
     * -> 2 增加的时候 需要keep track of direction
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // BFS, and reverse order
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;
        // direction
        boolean goRight = true;
        q.offer(root);
        TreeNode curNode;
        while (!q.isEmpty()) {
            // Get each row based on the current queue
            int rowCount = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            while (rowCount > 0) {
                curNode = q.poll();
                if (goRight) {
                    level.add(curNode.val);
                } else {
                    // Always add to the head
                    level.addFirst(curNode.val);
                }
                rowCount --;

                // Add to queue
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }

            }
            // We know next recursion, we'd toggle to left
            goRight = !goRight;
            result.add(level);
        }

        return result;
    }
}
