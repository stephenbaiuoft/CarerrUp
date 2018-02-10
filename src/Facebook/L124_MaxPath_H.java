package Facebook;

public class L124_MaxPath_H {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // idea to get max left and max right
    public int maxPathSum(TreeNode root) {
        int left = maxValue(root.left, 0);
        int right = maxValue(root.right, 0);
        return left+right + root.val;
    }

    public int maxValue(TreeNode node, int value) {
        if (node == null ){
            return value;
        }

        return value + Math.max(maxValue(node.left, node.val),
                maxValue(node.right, node.val));
    }
}
