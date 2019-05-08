package Leetcode;

public class L33_SearchRotated_M {
    public void runTest() {
        int[] rez = new int[] {
                4,4,4,5,1,4
        };

        int v = search(rez, 5);
        System.out.println(v);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length ==0) return -1;
        int minIdx = findMinIdx(nums);
        //if (target == nums[minIdx]) return minIdx;
        int m = nums.length;
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx - 1 : m - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) start = mid + 1;
            else end = mid;
        }
        int rez = nums[start] == target? start: -1;
        return rez;
    }

    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end -  start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
