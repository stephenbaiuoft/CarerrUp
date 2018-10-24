package ByMonth.august.March;

public class L153_FindMinRotatedArray_M {
    // key 找到关于min的最低的midpoint的condition！！
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;

        //0,1,2,4,5,6,7
        //4,5,6,7,0,1,2
        // find the minValue
        while(left < right) {
            int mid = left + (right - left) / 2;
            // i want to find the minimum element index
            if (nums[mid] > nums[right]) {
                // increment left
                left = mid + 1;
            }
            // nums[mid] <= nums[right]
            else {
                right = mid;
            }
        }

        return nums[left];

    }
}
