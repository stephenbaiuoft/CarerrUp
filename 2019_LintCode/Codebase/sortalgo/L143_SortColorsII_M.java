package Codebase.sortalgo;

public class L143_SortColorsII_M {
    private void quickSort(int[] nums, int lower, int upper) {
        if (lower >= upper) return ;// entire array is sorted
        int mid = lower+(upper-lower)/2;
        int pivot = nums[mid];
        int left = lower, right = upper;
        while (left <= right) {
            // skip the good entires
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            // here is the case where either nums[left] >= pivot && nums[right] <= pivot
            if (left <=right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        // left >= right at this point
        quickSort(nums, lower,right); // continue to sort the other parts
        quickSort(nums,left,upper);
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
