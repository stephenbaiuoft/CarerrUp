package BinarySearch;

public class L61_searchforarange_M {
    public int[] searchRange(int[] A, int target) {
        int[] rez = {-1, -1};
        if (A == null || A.length < 1) return rez;

        int left = findLowerBound(A, target);
        int right = findLowerBound(A, target + 1);
        if (A[left] != target) return rez;
        rez[0] = left;

        // cases to consider
        // [2,2], target 2,
        // right will return the last index of 1
        if (!((A[right] == target)|| (right == 0 ))){
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
