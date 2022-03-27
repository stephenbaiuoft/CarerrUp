package tree.traversal;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class L297_SerializeDes_H {


    private String separator = ",";
    private String nValue = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);

        return sb.toString();
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(this.nValue);
            sb.append(this.separator);
            return;
        } else {
            sb.append(node.val).append(this.separator);
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        ArrayDeque answer = new ArrayDeque(Arrays.asList(data.split(this.separator)));
        return decode(answer);

    }

    private TreeNode decode(ArrayDeque<String> answer) {
        if (answer.isEmpty()) {
            return null;
        }

        String sValue = answer.removeFirst();
        if (sValue.equals(this.nValue)) {
            return null;
        } else {
            // remove this answer
            TreeNode node = new TreeNode(Integer.parseInt(sValue));
            node.left = decode(answer);
            node.right = decode(answer);
            return node;
        }
    }

}

