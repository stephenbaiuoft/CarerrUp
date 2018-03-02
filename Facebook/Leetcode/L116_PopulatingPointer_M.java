package Leetcode;

public class L116_PopulatingPointer_M {
    class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }

    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null || root.right == null) return;
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        root.left.next = root.right;
        connect(root.left);
        connect(root.right);
    }
}
