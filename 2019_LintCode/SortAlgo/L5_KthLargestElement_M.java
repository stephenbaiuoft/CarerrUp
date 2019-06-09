package SortAlgo;

/*

Description
English
Find K-th largest element in an array.

IMPORTANT:
O(n) complexity!!!!!!! with O(1) Space

* Example
Example 1:

Input:
n = 1, nums = [1,3,4,2]
Output:
4
Example 2:

Input:
n = 3, nums = [9,3,2,4,8]
Output:
4
*
* */
public class L5_KthLargestElement_M {

    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
            return -1;
        }
        return quickSelect(nums.length-k, nums, 0, nums.length-1);
    }

    // define a function with searching lower and upper bound until reaching nth SMALLEST element
    // this is the quicksort template
    private int quickSelect(int n, int[] nums, int lower, int upper) {
        if (lower >= upper) {
            return nums[n]; // why returning nums[n]???
            // 因为你已经在每一次sort这个nums的array 根据pivot这个value， left 和 right 确定
            //      left之前的都小于pivot 已经 right之后的都大于pivot！！！！！很精辟的解法
        }
        int mid = lower + (upper - lower) / 2;
        // take the mid index as pivot value
        int pivot = nums[mid];
        // assign left to start from lower and right to start from upper
        int left = lower, right = upper;
        // --> to separate out left and right portion of the array
        // [lower, left] [right, upper] and check which segment the n SMALLEST would be in
        while (left <= right) {
            // skip entries that do not need to be swapped
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }

            // left value >= pivot && right value <= pivot
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        // by now, all values to [lower,left], pivot, [right, upper] based on our while-loop!
        // [lower, right,left,upper] and n is within those 4 possibilities
        if (n <= right) { //
            return quickSelect(n, nums, lower, right); // must be in the range of lower to right
        }
        //
        // in this case.... [left,upper] --> essentially n >= left!!!!!!!! important to know this man
        return quickSelect(n, nums, left, upper);

    }

    // dont use xor because same values would result in 0!!!!! important
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }




}

// solution template
/*

    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
            return -1;
        }
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[k];
        }

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }
        return nums[k];
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

* */