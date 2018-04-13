package March;

import java.util.Arrays;

public class L561_ArrayPartition_E {
    public L561_ArrayPartition_E() {
        int[] nums = new int[] {
                1,4,3,2
        };
        int rez = arrayPairSum(nums);
    }

    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0 ) return 0;

        int sum = 0;
        // sort in order
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2 ) {
            sum += nums[i];
        }

        return sum;
    }
}
