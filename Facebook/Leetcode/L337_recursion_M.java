package Leetcode;
/*
The thief has found himself a new place for his thievery again.
There is only one entrance to this area, called the "root."
Besides the root, each house has one and only one parent house.
After a tour, the smart thief realized that "all houses in this place forms a binary tree".
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

    Example 1:

    Input: [3,2,3,null,3,null,1]

         3
        / \
       2   3
        \   \
         3   1

    Output: 7
    Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
    Example 2:

    Input: [3,4,5,1,3,null,1]

         3
        / \
       4   5
      / \   \
     1   3   1

    Output: 9
    Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
*
* */
public class L337_recursion_M {

    public int rob(TreeNode root) {
        int[] vals = dfs(root);
        return Math.max(vals[0], vals[1]);
    }

    // vals [0] -> rob,  vals[1] -> norob
    public int[] dfs(TreeNode node) {
        // base case
        if (node == null) {
            return new int[2];
        }

        int[] lVals = dfs(node.left);
        int[] rVals = dfs(node.right);
        int[] cVals = new int[2];

        // case 1:  rob the current node
        //   then-> would be node.val + lVals[1](norob) + rVals[1](norob)
        cVals[0] = node.val + lVals[1] + rVals[1];

        // case 2: no rob the current node
        //   then-> would be maximum value from left + maximum value from right
        cVals[1] = Math.max(lVals[0], lVals[1]) +
                Math.max(rVals[0], rVals[1]);

        return cVals;

    }
}
