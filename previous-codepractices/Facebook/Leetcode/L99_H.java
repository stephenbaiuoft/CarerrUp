package Leetcode;

/*
*
* https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal/165268
*
* */

public class L99_H {
    private TreeNode first = null;
    private TreeNode second = null;
    // to avoid the very first comparison when prevNode has not been initialized
    private TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderLogic(root);
        int val = second.val;
        second.val = first.val;
        first.val = val;
    }

    private void inorderLogic(TreeNode node) {
        // base case
        if (node == null) return;

        inorderLogic(node.left);
        if (first == null && prevNode.val >= node.val) {
            first = prevNode;
        }

        if (first != null && prevNode.val >= node.val) {
            second = node;
        }

        // each iteration update the prevNode
        prevNode = node;

        inorderLogic(node.right);

    }
}
