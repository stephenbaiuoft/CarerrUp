package ByMonth.august.March;

public class L112_PathSum_E {
    // always --> base case of null is very USEFUL!!
    public boolean hasPathSum(TreeNode root, int sum) {
        // base case
        if(root == null) return false;

        // now you can safety check for leaf as
        // when root reached here CANNOT BE NULL!
        else if(root.left == null && root.right == null) {
            // leaf node and check whether reached sum
            return root.val == sum;
        }

        // default
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }
}
