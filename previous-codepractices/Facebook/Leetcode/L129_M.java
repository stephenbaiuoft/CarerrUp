package Leetcode;

public class L129_M {
    private int rez = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return rez;
    }

    // DFS with carrying sum!
    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        sum = sum * 10 + node.val;

        // base case of a leave
        if (node.left == null && node.right == null) {
            rez += sum;
            return;
        }

        // otherwise, do this
        dfs(node.left, sum);
        dfs(node.right, sum);
    }
}
