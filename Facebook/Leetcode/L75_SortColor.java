package Leetcode;

public class L75_SortColor {
    public void test(){
        int[] nums = new int[] {
                0, 1
        };
        sortColors(nums);
    }

    public void sortColors(int[] nums) {

        int leftBound = 0;
        int rightBound = nums.length - 1;
        int i = 0;
        while(i <= rightBound) {

            if (nums [i] == 0) {
                nums[i] = nums[leftBound];
                nums[leftBound] = 0;
                leftBound ++;
            }

            if (nums[i] == 2) {
                nums[i] = nums[rightBound];
                nums[rightBound] = 2;
                rightBound --;
                i--;
            }

            i++;
        }
    }

}
