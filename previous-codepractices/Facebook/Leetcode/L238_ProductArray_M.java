package Leetcode;

public class L238_ProductArray_M {
    public int[] productExceptSelf(int[] nums) {
        int[]output = new int[nums.length];
        int forward = 1;
        int backward = 1;
        for(int i = 0; i < nums.length; i ++) {
            output[i] = forward;
            forward *= nums[i];
        }

        for(int j = nums.length - 1; j > -1; j--) {
            output[j] *= backward;
            backward *= nums[j];
        }

        return output;
    }
}
