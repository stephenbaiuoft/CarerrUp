package twopointers.list;

public class L283_MoveZero_E {
    public static void main(String[] args) {
        L283_MoveZero_E p = new L283_MoveZero_E();
        p.moveZeroes(new int[]{ 1,2,0,3,12});
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) return;
        // the iIndex-> insertion index you can safely copy to
        int iIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[iIndex] = nums[i];
                iIndex++;
            }
        }
        // fill the rest to 0
        while(iIndex < nums.length) {
            nums[iIndex] = 0;
            iIndex++;
        }
    }
}
