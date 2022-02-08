package ByMonth.august.March;

public class L27_RemoveElement_E {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        // j to keep track of the one right after valid position,
        // assuming j = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
