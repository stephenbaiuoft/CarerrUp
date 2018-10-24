package Leetcode;

public class L108_ArrayToBST_E {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // helper funciton
        return buildTree(nums, 0, nums.length -1);
    }

    // return
    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            // base case of null
            return null;
        }
        // No Need for this ---> as the latter covers it already
//        else if (left == right){
//            // base case of single value
//            return new common.data.types.TreeNode(nums[left]);
//        }

        int mid = left + (right - left )/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid +1, right);
        return root;
    }
}
