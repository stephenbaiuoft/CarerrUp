package twopointers.list;

public class L26_RemoveDuplicatesFromSorted_E {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int toWrite = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) { // found larger elemtn
                nums[toWrite] = nums[i];
                toWrite+=1;
                prev = nums[i];
            }
        }
        return toWrite;

    }
}
