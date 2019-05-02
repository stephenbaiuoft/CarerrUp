package Codebase.recursion;

/*
* Description
For an array A, if i < j, and A [i] > A [j], called (A [i], A [j]) is a reverse pair.
return total of reverse pairs in A.

Have you met this question in a real interview?
Example
Example1

Input:  A = [2, 4, 1, 3, 5]
Output: 3
Explanation:
(2, 1), (4, 1), (4, 3) are reverse pairs
Example2

Input:  A = [1, 2, 3, 4]
Output: 0
Explanation:
No reverse pair

* */

// 思路是 mergeSort在合并的时候 你可以进行order错位的计算
// 另外一种是 FenwickTree sort + order错位来进行计算
public class L532_ReversePairs_M {
    /**
     * @param A: an array
     * @return: total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // write your code here
        return mergeSort(A, 0, A.length-1);
    }

    // returns # of swaps for given array between left and right
    private int mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int count = 0;
        int mid = start + (end-start)/2;
        count += mergeSort(A, start, mid);
        count += mergeSort(A, mid+1, end);

        // Here you call merge as another logical layer of putting things together
        count += merge(A, start, mid, end);

        return count;
    }

    // given the array A merge [start,mid] and [mid+1, right] into 1 array
    private int merge(int[] A, int start, int mid, int end) {
        int[] tmp = new int[A.length];
        int leftStartIndex = start; // array on the left
        int rightStartIndex = mid+1; // array on the right --> visualize the entire merging process
        int mergeStartIndex = start; // where the start of the merging array is
        int count = 0;

        // doing comparison
        while (leftStartIndex <= mid && rightStartIndex <= end) {
            // case of no swap
            if (A[leftStartIndex] <= A[rightStartIndex]) {
                tmp[mergeStartIndex++] = A[leftStartIndex++];
            } else { // case when the element on the left > element on the right
                tmp[mergeStartIndex++] = A[rightStartIndex++];
                count += mid - leftStartIndex + 1; // so all the indices >= leftStartIndex to mid are greater than A[right]
            }
        }
        // copying remaining
        while(leftStartIndex <= mid) {
            tmp[mergeStartIndex++] = A[leftStartIndex++];
        }
        while(rightStartIndex <= end) {
            tmp[mergeStartIndex++] = A[rightStartIndex++];
        }

        // overwrite A with tmp
        for (int i = start; i <= end; i++) {
            A[i] = tmp[i];
        }

        return count;
    }
}
