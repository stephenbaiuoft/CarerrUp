package March;

public class L41_FirstMissingP_H {
    public int firstMissingPositive(int[] nums) {
        // bucket where supposed we put in the ideal case, where 1 is the smallest
        // indice:0, 1, ....
        // val:   1, 2, ....


        // default case
        if(nums == null || nums.length < 1) return 1;
        for(int i = 0; i < nums.length; i++) {
            // the 3rd case condition:
            // the val is nums[i]
            // the index is nums[i] - 1
            // so the value @ index nums[i] - 1 should be nums[i] by our arrangement
            // IF NOT THEN: swap !!!!!
            while(nums[i] > 0 && nums[i] <=nums.length
                    &&nums[nums[i] - 1] != nums[i] ) {
                // store this value
                int tmp = nums[nums[i] - 1];
                // set the value @ nums[i]-1 to be nums[i] which makes sense
                nums[nums[i]-1] = nums[i];

                // now put tmp value @ ith index and with while loop to check again
                nums[i] = tmp;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            // i +1 is our by definition ideal case
            if (nums[i] != i+1) {
                return i+1;
            }
        }

        // this is the case where:

        //indice: 0, 1,
        // val:   1, 2   ====>  so this case we only miss the last val
        return nums.length + 1;
    }
}
