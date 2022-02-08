package Microsoft;


/**
 * Rotate an array of n elements to the right
 * by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 [show hint]

 Related problem: Reverse Words in a String II


 Key: rotate array ==> equiavlent to reverse the array!!!
 *
 */

public class L189_rotateArray_E {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return ;
        }
        // in case k is a multiple of nums.length!!!!!!!
        k = k % ( nums.length );
        // reverse entire array
        reverse(nums, 0,  nums.length - 1);
        // reverse
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1 );
    }

    private void reverse(int[] ary, int start, int end) {
        while(start < end) {
            ary[start] ^= ary[end];
            ary[end] ^= ary[start];
            ary[start] ^= ary[end];
            start ++;
            end --;
        }
    }
}
