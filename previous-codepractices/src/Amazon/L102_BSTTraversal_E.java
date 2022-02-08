package Amazon;

import java.util.*;

/**
 * Given a binary Tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).

 For example:
 Given binary Tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
     /  \
    15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]

 */

public class L102_BSTTraversal_E {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        levelOrder(root);
    }

    // recursin!! think of height! and how to add!s
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sets = new ArrayList<>();
        addLevel(root, 0, sets);

        return sets;
    }

    private void addLevel(TreeNode node, int height, List<List<Integer>> sets){
        if(node == null) return;
        // initially: 0 == 0
        // then when 1 > 0, meaning you should add a new set now
        // and then re-cursion will keep creating only the first longest!!!s
        if(height >= sets.size()) {
            sets.add(new ArrayList<>());
        }
        sets.get(height).add(node.val);
        addLevel(node.left, height +1, sets);
        addLevel(node.right, height + 1, sets);
    }

    // Own Implementation!!
//    public List<List<Integer>> levelOrder(common.data.types.TreeNode root) {
//        List<List<Integer>> set = new ArrayList<>();
//        Queue<common.data.types.TreeNode> curQueue = new ArrayDeque<>();
//
//        if (root != null ){
//            curQueue.add(root);
//
//            while(!curQueue.isEmpty()) {
//                List<Integer> levelSet = new ArrayList<>();
//                Queue nextQueue = new ArrayDeque();
//                while(!curQueue.isEmpty()){
//                    common.data.types.TreeNode curNode = curQueue.poll();
//
//                    levelSet.add(curNode.val);
//                    // assigning next ones
//                    if(curNode.left != null )
//                        nextQueue.add(curNode.left);
//                    if(curNode.right != null)
//                        nextQueue.add(curNode.right);
//
//
//                }
//                // adding to set!
//                set.add(levelSet);
//                // re-assign curQueue
//                curQueue = nextQueue;
//            }
//        }
//        for( List<Integer> sol: set) {
//            System.out.println(Arrays.toString(sol.toArray()));
//        }
//        return set;
//    }
}
