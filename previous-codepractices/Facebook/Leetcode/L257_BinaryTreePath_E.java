package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class L257_BinaryTreePath_E {
    public List<String> rez = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return rez;

        traverse(root, "");
        return rez;
    }

    // traverse
    public void traverse(TreeNode node, String sp) {
        String sv = Integer.toString(node.val);
        if ( node.left == null && node.right == null) {
            String add = sp + "->" + sv;
            rez.add( add.substring(2));
        }
        else if (node.left != null && node.right !=null) {
            traverse(node.left, sp + "->" + sv);
            traverse(node.right, sp + "->" + sv);
        }
        else if (node.left != null) {
            traverse(node.left, sp + "->" + sv);
        }
        else if (node.right != null) {
            traverse(node.right, sp + "->" + sv);
        }
    }
}
