package tree_traversal;

/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
*
* */

/*
一种思路 很机智
* class Solution {
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }
}
Explanation

The height of a tree can be found by just going left. Let a single node tree have height 0. Find the height h of the whole tree. If the whole tree is empty, i.e., has height -1, there are 0 nodes.

Otherwise check whether the height of the right subtree is just one less than that of the whole tree, meaning left and right subtree have the same height.

If yes, then the last node on the last tree row is in the right subtree and the left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of the left subtree plus the 1 root node plus recursively the number of nodes in the right subtree.
If no, then the last node on the last tree row is in the left subtree and the right subtree is a full tree of height h-2. So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus recursively the number of nodes in the left subtree.
Since I halve the tree in every recursive step, I have O(log(n)) steps. Finding a height costs O(log(n)). So overall O(log(n)^2).
* */


import common.data.types.TreeNode;

public class L222_CountCompleteTreeNodes_M {
    public L222_CountCompleteTreeNodes_M() {
      TreeNode root = buildTestGraph();
      int val = countNodesBug(root);

    }

    // get the height of the node, by going all the way to the left
    // and note, the total # of nodes in a complete binary tree is
    // 2^(h+1)
    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + height(node.left);
    }

    public int countNodesBug(TreeNode root) {

        int h = height(root);
        if (h < 0) return 0;

        int hRight = height(root.right);
        // case where the last node is in the right subtree then->
        // 1 << (h) - 1 (from the left subtree) + 1 (from the root) + countNodes(root.right)
        if (hRight == h - 1) {
            int tmp = 1 << h;
            int val = countNodesBug(root.right);
            return tmp + val;
        }
        // other case where the last node is in the left subtree then->
        // (1 << h-1) - 1 (from the right subtree) + 1 (from the root) + countNodes(root.left)
        return (1 << h-1) + countNodesBug(root.left);

    }



    private TreeNode buildTestGraph() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        return root;
    }
}
