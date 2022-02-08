package Amazon;


import java.util.*;

public class L449_SerializeDeserialize_M {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private String nullCharacter = "x";
    private String separator = ",";

    // Encodes a Tree to a single testing.string.
    public String serialize(TreeNode root) {

        StringBuilder buffer = new StringBuilder();
        buildStr(root, buffer);
        return buffer.toString();
    }

    private void buildStr(TreeNode node, StringBuilder str) {
        if (node == null){
            str.append(nullCharacter).append(separator);
        } else {
            str.append(node.val).append(separator);
            buildStr(node.left, str);
            buildStr(node.right, str);
        }
    }


    // Decodes your encoded data to Tree.
    public TreeNode deserialize(String data) {
        String[] components = data.split(separator);

        List list=  Arrays.asList(components);
        LinkedList linkedList = new LinkedList(list);

        return buildTree(linkedList);
    }

    private TreeNode buildTree(LinkedList<String> linkedList){
        if (!linkedList.isEmpty()){
            String element = linkedList.removeFirst();
            if (nullCharacter.equals(element)){
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(element));
                node.left = buildTree(linkedList);
                node.right = buildTree(linkedList);
                return node;
            }

        }
        // default
        return null;
    }
}
