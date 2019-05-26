package Leetcode;


/*
*
    Given a non-empty binary Tree, find the maximum path sum.

    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the Tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

    Example 1:

    Input: [1,2,3]

           1
          / \
         2   3

    Output: 6
    Example 2:

    Input: [-10,9,20,null,null,15,7]

       -10
       / \
      9  20
        /  \
       15   7

    Output: 42
*
* */
public class L123_H {

    private int gMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int r = dfs(root);
        System.out.print(r);
        return gMax;
    }

    // DFS SortAlgo to compute the maximum path value including this node
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right  = dfs(node.right);

        // update cMax & gMax here
        int cMax = 0;
        if (left >=0 && right >=0) {
            cMax = Math.max(left, right) + node.val;
            gMax = Math.max(gMax, left + right + node.val);
        }
        else if (left < 0 && right >=0) {
            cMax = node.val + right;
            gMax = Math.max(gMax, cMax);
        }
        else if (left >= 0 && right < 0) {
            cMax = node.val + left;
            gMax = Math.max(gMax, cMax);
        }
        else if (left < 0 && right < 0) {
            cMax = node.val;
            gMax = Math.max(gMax, cMax);
        }

        return cMax;

    }
}
