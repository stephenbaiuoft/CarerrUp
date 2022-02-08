package Leetcode;

public class L34v2_M {
    // Another Method of utilizing findLowerBound ONLY
    public int[] searchRange(int[] nums, int target) {
        int[] rez = {-1, -1};
        if (nums == null || nums.length < 1) return rez;

        int left = findLowerBound(nums, target);
        int right = findLowerBound(nums, target + 1);
        if (nums[left] != target) return rez;
        rez[0] = left;

        // cases to consider
        // [2,2], target 2,
        // right will return the last index of 1
        if (!((nums[right] == target)|| (right == 0 ))){
            right = right - 1;
        }
        rez[1] = right ;
        return rez;
    }

    // log(n)
    private int findLowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            // nums[mid] >= target
            else {
                right = mid ;
            }
        }
        return left;
    }
}
