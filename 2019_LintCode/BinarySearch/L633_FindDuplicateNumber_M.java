package BinarySearch;

public class L633_FindDuplicateNumber_M {
    public int findDuplicate(int[] nums) {
        int low = 1;
        // definition of n (due to the question statement)
        int high = nums.length - 1;

        while(low < high) {
            int mid = (low + high)/2;
            int count = 0; // how many element greater than mid and less (including mid)
            for(int n: nums) {
                if (n <= mid) {
                    count++;
                }
            }

            // # of elements greater than mid
            // meaning extra element is less than mid for sure
            // so move down the high value
            if(count > mid) {
                high = mid ; // get high as lower bound
            } else {
                low = mid+1;
            }

        }

        return low;
    }
}
