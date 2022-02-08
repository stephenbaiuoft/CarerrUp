package Amazon.OA2Review;

/**
 *
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

 For example, these are arithmetic sequence:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic.

 1, 1, 2, 5, 7

 A zero-indexed array A consisting of N numbers is given. A slice of that array is
 any pair of integers (P, Q) such that 0 <= P < Q < N.

 A slice (P, Q) of array A is called arithmetic if the sequence:
 A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.
 */
/**
 *
 * idea:
 * 1,2,3   total: 1 (3-2)(3-1)/2 = 1
 * 1, 2, 3, 4    total: 3 (4-2)(4-1)/2 = 3
 * 1, 2, 3, 4, 5  total: 6 (5-2)(5-1)/2 = 6
 */

public class L413_ArithmaticSlice_M {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) return 0;

        int sum = 0;
        int i = 0;

        // -2 because the minimum is 3
        while (i < A.length - 2) {
            int iEnd = i + 2;
            int difference = A[i+1] - A[i];
            int sequenceCount = 2;

            while(iEnd < A.length && difference == A[iEnd] - A[iEnd-1]) {
                sequenceCount++;
                iEnd++;
            }
            // there found one
            if(sequenceCount > 2 ) {
                sum += (sequenceCount - 2)*(sequenceCount -1) / 2;
                // given index iEnd and index iEnd -1 difference changed
                // reset i
                i = iEnd - 1;
            } else {
                i++;
            }

        }

        return sum;
    }
}
