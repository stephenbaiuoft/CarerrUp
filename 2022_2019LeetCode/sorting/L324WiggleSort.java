package sorting;

import java.util.Arrays;

public class L324WiggleSort {
    public L324WiggleSort() {
        int[] test = {1,5,1,1,6,4};
        wiggleSort(test);

    }

    public void wiggleSort(int[] nums) {
        // https://leetcode.com/problems/wiggle-sort-ii/discuss/1659114/Java-solution-with-explained-pictures
        Arrays.sort(nums);
        int[] newnums = new int[nums.length];
        int k = 0;
        // secondLargestIndex value is always > firstLargestIndex

        // firstLargestIndex is the odd size mid (size = 3 =====> 0,1,2, s = 1 = (3+1)/2 = 1
        // firstLargestIndex is the even size mid by 1  (size = 4 ====> 0, 1, 2,3,4, s = (4+1)/2 - 1 = 1
        int firstLargestIndex = (nums.length + 1) / 2 - 1;

        int secondLargestIndex = nums.length - 1;

        // Re-arrange where
        //  0                       1                          2                        3
        // firstLargest.largest, secondLargest,largest, firstLargest.2nd_largest, secondLargest.2nd_largest, firstLargest.3rdLargest, secondLargest.3rdLargest)
        //
        while(k < nums.length){
            if(k % 2 == 0){ //even, secondLargest.largest
                newnums[k++] = nums[firstLargestIndex--];
            }else{ // odd
                newnums[k++] = nums[secondLargestIndex--];
            }
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = newnums[i];
        }
    }

}
