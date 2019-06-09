package Leetcode;

/*
* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    Example 1:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    Example 2:

    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]
* */
public class L34_M {
    public L34_M() {
        int[] input = {5,7,7,8,8,10};
        int val = 8;
        int rez = findUpperBound(input, val);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] rez = {-1, -1};
        if (nums == null || nums.length < 1) return rez;

        int left = findLowerBound(nums, target);
        int right = findUpperBound(nums, target);
        if (nums[left] != target) return rez;
        rez[0] = left;
        rez[1] = right;
        return rez;
    }

    /*
    * 解体思路：
    *
    * 因为 right = mid， 而你while-loop的terminate的逻辑是 left < right (as long as it is true)
    * so in case of duplicates, even nums[mid] = right for the first mid (that is actually correct),
    * -> 这个algorithm还是会继续 ==> 意味着把right 就继续挤压
    *
    *
    * */
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

    /**
     * 这就是另外一个很经典的解体思路 ===> 你看 这一次是把 left 继续挤压==》
     *  这样类比 就把最右边的index算出来了
     *
     */


    private int findUpperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right && left != right -1) { // must ==> left != right -1 因为 mid = left + (right -left)/2 and 存在infinite loop的情况
            int mid = left + (right -left) / 2; // 这里 你考虑 left=0, right=1, mid = 0+(1)/2 = 0 always!!! with first if true
            if (nums[mid] <= target) {
                left = mid;
            }
            // nums[mid] > target
            else {
                right = mid - 1;
            }
        }
        // 这里的terminate的情况！！！
        return nums[right] == target? right: left; //所以最后 查一查 到底是 right 等于target还是left 等于target 毕竟可以在 left = right -1的情况 terminate
    }
}
