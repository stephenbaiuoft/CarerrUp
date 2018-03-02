package Leetcode;

public class L100_SameTree {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        String p1 = traverse(p, "");
        String p2 = traverse(q, "");
        return p1.equals(p2);
    }

    public String traverse(TreeNode node, String rez) {
        if (node == null) {
            rez += "null";
            return rez;
        }
        else {
            rez += Integer.toString(node.val) + ".";
            rez = traverse(node.left, rez);
            rez = traverse(node.right, rez);
        }
        return rez;
    }
}

