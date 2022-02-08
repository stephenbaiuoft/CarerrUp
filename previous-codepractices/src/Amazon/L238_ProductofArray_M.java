package Amazon;

/*
*
* Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Solve it without division and in O(n).

    For example, given [1,2,3,4], return [24,12,8,6].


    Follow up:
    Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

* */

// idea two arrays: forward and reverse up to index i

// this beats around 29%
public class L238_ProductofArray_M {
    public int[] productExceptSelfSolution(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;


    }


// Slow Implementation > 8.83% speed rate
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1) return nums;

        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];
        int[] result = new int[nums.length];

        forward[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            forward[i] = forward[i-1] * nums[i];
        }

        backward[nums.length - 1 ] = nums[nums.length - 1];
        for(int j = nums.length - 2; j > -1 ; j-- ){
            backward[j] = backward[j + 1] * nums[j];
        }

        for(int i = 1; i < nums.length - 1; i++) {
            result[i] = forward[i-1] * backward[i+1];

        }

        result[0] = backward[1];
        result[nums.length - 1 ] = forward[nums.length - 2];

        return result;

    }

}
