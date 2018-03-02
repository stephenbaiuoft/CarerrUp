package Leetcode;

public class L283_MoveZeros_E {
    public void test(){
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);

    }

    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }
        // note ++ is only called afterwards!
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

    }



}
