package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePath {
    public BinaryTreePath(){
        TreeNode root = new TreeNode(1);


    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rez = new LinkedList<>();
        if (root == null) return rez;
        dfs(root, rez, "");

        return rez;
    }

    private void dfs(TreeNode node, List<String> l, String path) {
        if (node.left == null && node.right == null) {
            l.add(path + node.val);
            return;
        }

        String p = path + node.val + "->";
        if (node.left != null) {
            dfs(node.left, l, p);
        }
        if (node.right != null) {
            dfs(node.right, l, p);
        }
    }
}
