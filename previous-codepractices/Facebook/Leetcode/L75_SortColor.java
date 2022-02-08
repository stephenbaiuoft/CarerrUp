package Leetcode;

public class L75_SortColor {
/*
* 3 colors by 0, 1, and 2 mixed
* sorted them in place such that 0s, 1s, and 2s
*
* */
    public void test(){
        int[] nums = new int[] {
                0, 1
        };
        sortColors(nums);
    }

    public void sortColors(int[] nums) {

        int leftBound = 0; // the index that should be putting 0 to
        int rightBound = nums.length - 1; // the index that should be putting 2 to
        int i = 0;
        while(i <= rightBound) {
        // 注意一定要用2个if！ 因为leftBound的值可以是2

            if (nums [i] == 0) {
                // swap the current value of nums[leftBound] to i index anyway
                nums[i] = nums[leftBound];
                // leftBound
                nums[leftBound] = 0;
                leftBound ++;
            }

            if (nums[i] == 2) {
                nums[i] = nums[rightBound];
                nums[rightBound] = 2;
                rightBound --;
                // i-- 因为i存了 nums[rightBound]的值 所以 必须重新过一次 整个loop的逻辑
                i--;
            }

            i++;
        }
    }

}
