package Leetcode;

public class L270_E {
    public L270_E() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);

        int rez = closestValueIterative(root, 3.428571);

    }

    public int closestValueIterative(TreeNode root, double target) {
        int ret = root.val;
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }
            root = root.val > target? root.left: root.right;
        }
        return ret;
    }

    // interesting worth noting
    private double minDiff = Double.MAX_VALUE;
    private int minVal = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        // base case
        if (root == null) return minVal;
        else if (target <= root.val) {
            if (root.val - target < minDiff) {
                minVal = root.val;
                minDiff = root.val - target;
            }
            return closestValue(root.left, target);
        }
        // target > root.val!
        else {
            if (target - root.val < minDiff) {
                minVal = root.val;
                minDiff = root.val - target;
            }
            return closestValue(root.right, target);
        }

    }



}
