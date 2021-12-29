package sorting.algo;

import java.util.Arrays;

public class quickSort {
    // Always think of quickSort with pivot + partition
    // 测试 https://www.lintcode.com/problem/143/description

    public void sortColors2(int[] colors, int k) {

    }

    public quickSort() {
//        int[] array = { 2,1,1,2,2};
//
//        quickSortUsingPartitioning(array, 0, array.length-1);
//        Arrays.stream(array).forEach(
//            x -> System.out.print(x + ",")
//        );

        int [] array = {2, 3, 5, 4, 7};
        quickSort(array, 0, array.length-1);
    }

    // The following quick sort uses partitioning
    // Pseudo code from Algorithm Textbook
    public void quickSortUsingPartitioning(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSortUsingPartitioning(array, left, pivotIndex - 1);
            quickSortUsingPartitioning(array, pivotIndex + 1, right);
        }
    }

    // THIS returns the pivot point
    public int partition(int[] array, int left, int right) {

        int pivotValue = array[right];
        // indexWithValueSmallerThanP, always increment it before using it
        int indexWithValueSmallerThanP = left - 1;

        // from left to right, not including right because array[right] = pivotValue to be swapped later
        for (int i = left ; i < right; i++) {
            // swap if the value is smaller than pivotValue
            if (array[i] < pivotValue) {
                // increment by 1 to get the indexToBeSwapped
                swap(array, indexWithValueSmallerThanP + 1, i);
                // move indexWithValueSmallerThanP to the right by 1
                indexWithValueSmallerThanP += 1;
            }
        }

        // swap pivotValue with the indexWithValueSmallerThanP
        swap(array, indexWithValueSmallerThanP + 1, right);

        // This is the new pivot index
        return indexWithValueSmallerThanP + 1;
    }


    // quickSort就记住while left right也行 因为这样 pivot这个不需要特地去记住swap的index
    // 第二个是 left <= right这个是等号
    // The following quickSort uses while && partitioning logic is self contained
    private void quickSort(int[] nums, int lower, int upper) {
        if (lower >= upper) return ;// entire array is sorted
        int mid = lower+(upper-lower)/2;
        int pivot = nums[mid];
        int left = lower, right = upper;
        while (left <= right) {
            // skip the good entries
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


    // swaps i and j values
    private void swap(int[]array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

}
