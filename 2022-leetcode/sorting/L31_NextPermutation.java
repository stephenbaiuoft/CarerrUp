package sorting;

public class L31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int endIndex = nums.length - 1;
        while (endIndex > 0) {
            if (nums[endIndex - 1] < nums[endIndex]) {
                break;
            }
            endIndex--;
        }
        // meaning descending order
        if (endIndex == 0) {
            reverseSort(nums, 0, nums.length-1);
            return;
        }

        // we found the endIdex to swap
        // get the val needs to be swapped
        int val = nums[endIndex- 1];
        int j = nums.length - 1;

        // note j goes from right to left!! important
        // as you always get the larger item at the higher index!!!!!!
        while(j >= endIndex) {
            if (nums[j] > val) {
                break;
            }
            j--;
        }
        // j is found, and make the swap
        reverseSort(nums, endIndex - 1, j );
        // now, the next largest meaning --> between endIndex and nums.length - 1
        // before (large to small) --> change to (small to large)
        reverseSort(nums, endIndex, nums.length - 1);
    }

    // swap every element in numbs
    private void reverseSort(int[] nums, int left, int right) {
        while(left < right) {
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];
            left++;
            right--;
        }
    }
}
