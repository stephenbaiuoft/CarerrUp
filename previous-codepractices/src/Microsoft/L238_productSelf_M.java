package Microsoft;

public class L238_productSelf_M {

    public int[] Solution(int[] nums) {
        if ( nums == null || nums.length == 0 ) {
            return nums;
        }

        int[] prod = new int[nums.length];
        prod[0] = 1;

        // left to right
        for (int i = 1; i < nums.length; i++) {
            prod[i] = prod[i-1] * nums[i - 1];
        }
        int right = 1;
        // right to left
        for (int i = nums.length - 1; i >=0; i--) {
            // off set by 1 because right is modified later!
            prod[i] *= right;
            // product nums[i]
            right *= nums[i];
        }

        return prod;

    }
}
