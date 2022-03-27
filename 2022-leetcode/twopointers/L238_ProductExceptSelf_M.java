package twopointers;

public class L238_ProductExceptSelf_M {
    // 思路 一个answer array先存第一次 从左到右
    // 2pointer left right 分开,
    // left算从左边开始的（不包括自己)的product, left = 1

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        // left, right accumulator
        // [1,2,3,4]
        // [1,1,2,6] left
        // [1,1*12,2*4=8,6*1=6]
        // right
        // []
        // iterate back
        // []
        int left = 1, right = 1;

        // update once
        for (int i = 0; i < nums.length; i++ ) {
            answer[i] = left;
            left *= nums[i];
        }

        for (int i = nums.length-1; i > -1; i--) {
            answer[i] = right * answer[i];
            right *= nums[i];
        }

        return answer;
    }
}
