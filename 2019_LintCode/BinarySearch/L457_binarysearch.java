package BinarySearch;

public class L457_binarysearch {
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        // write your code here
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < target) {
                left = mid + 1; //safely advance left
            } else { // target <= mid --> right = mid
                right = mid;
            }
        }
        // left = right
        return nums[left] == target ? left: -1;
    }
}
