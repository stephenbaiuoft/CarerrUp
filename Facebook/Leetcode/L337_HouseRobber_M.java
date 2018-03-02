package Leetcode;

public class L337_HouseRobber_M {
    public int rob(TreeNode root) {
        int robRoot = helper(root, true);
        int noRobRoot = helper(root, false);
        return robRoot > noRobRoot? robRoot: noRobRoot;
    }

    public int helper(TreeNode node, boolean rob) {
        if(node == null) {
            return 0;
        }

        else {
            int left = 0;
            int right = 0;
            if (rob) {
                if (node.left !=null){
                    left = helper(node.left, false);
                }
                if (node.right !=null) {
                    right = helper(node.right, false);
                }
                return left + right + node.val;
            }
            else {
                if (node.left !=null){
                    left = helper(node.left, true);
                    left = Math.max(left, helper(node.left, false));
                }
                if (node.right !=null) {
                    right = helper(node.right, true);
                    right = Math.max(right, helper(node.right, false));
                }
                return left + right;
            }
        }

    }
}
