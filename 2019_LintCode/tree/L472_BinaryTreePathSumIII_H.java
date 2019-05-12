package tree;

import java.util.*;

/*
* Give a binary tree, and a target number, find all path that the sum of nodes equal to target, the path could be start and end at any node in the tree.

Example
Example1

Input:
tree = {1,2,3,4}
target = 6
Output:
[
  [2, 4],
  [2, 1, 3],
  [3, 1, 2],
  [4, 2]
]
Explanation:
The tree is look like this:
    1
   / \
  2   3
 /
4
* */
public class L472_BinaryTreePathSumIII_H {
    class ParentTreeNode {
      public int val;
      public ParentTreeNode parent, left, right;
    }

    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // write your code here
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        dfs(root, target, list);
        return list;
    }

    // explore all possbilities by preOrder visiting each node
    public void dfs(ParentTreeNode root, int target, List<List<Integer>> results) {
        if (root == null)
            return;

        List<Integer> visited = new ArrayList<Integer>();
        findSum(root, null, target, visited, results);

        dfs(root.left, target, results);
        dfs(root.right, target, results);
    }

    // find sum starting from the current node (including)
    // 这种做法 是base case少了一点 但是你看exploring的handling的时候 多了很多null的check
    public void findSum(ParentTreeNode node, ParentTreeNode prev, int remain,
                        List<Integer> visited, List<List<Integer>> list) {
        visited.add(node.val);
        remain -= node.val; // update remain

        if (remain == 0) {
            list.add(new LinkedList<>(visited));
        }

        // make sure you keep exploring to next level
        if ( node.parent != null && node.parent != prev)
            findSum(node.parent, node, remain, visited, list);

        if ( node.left != null && node.left  != prev)
            findSum(node.left, node, remain, visited, list);

        if ( node.right != null && node.right != prev)
            findSum(node.right, node, remain, visited, list);

        visited.remove(visited.size() - 1);
    }
}
