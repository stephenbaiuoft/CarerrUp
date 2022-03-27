package twopointers.list;

public class L28_MergeSortedArray_E {
    // 解体思路 2 pointer来记录i j 哪个可以开始copy
    // num1 是有extra space 且可以被记录不用担心overwrite的
    // 所以可以从 num1 最后开始


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1[1,2,3,  0,0,0] nums2[1,1,1]
        // o(n) first, 2 pointers i, j start
        // start from the last non-important places because nums1[,    00000 can be overriden]
        int i = m-1, j = n-1;
        int copy = nums1.length-1;

        while (i > -1  && j > -1) {
            // copy i value, and then decrease
            if (nums1[i] >= nums2[j]) {
                nums1[copy--] = nums1[i--];
            } else { // nums1[i] < nums2[j]
                nums1[copy--] = nums2[j--];
            }
        }

        while (i > -1) {
            nums1[copy--] = nums1[i--];
        }

        while (j > -1) {
            nums1[copy--] = nums2[j--];
        }

    }
}
