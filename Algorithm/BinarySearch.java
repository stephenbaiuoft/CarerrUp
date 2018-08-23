public class BinarySearch {
    // given a sorted array, find if k exists
    public boolean bs(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;

        while(l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else{
                // definitely smaller --> allows u to increment left
                l = mid +1;
            }
        }
        // last check if nums[l] == target ... this case l = r
        return nums[l] == target;
    }
}
