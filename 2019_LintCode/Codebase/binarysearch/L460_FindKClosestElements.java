package Codebase.binarysearch;

import java.util.Arrays;

public class L460_FindKClosestElements {

    public int[] kClosestNumbers(int[] A, int target, int k) {
        int left = getClosest(A, target);
        int right = left + 1; // the one next to left

        int[] rez = new int[k];
        for (int i =0; i<k;i++) { // only need k element
            if (isLeftCloser(A, target, left, right)) {
                rez[i]= A[left--];// update left
            } else {
                rez[i] = A[right++]; // update right
            }
        }

        return rez;
    }

    private boolean isLeftCloser(int[] A, int target, int left, int right) {
        if (left < 0) {
            return false;
        }

        if (right >= A.length) { // right out of boundary.... only left
            return true;
        }

        return Math.abs(A[left]-target) <= Math.abs(A[right]-target);
    }

    private int getClosest(int[] A, int target) {
        // the left most as a starting point
        int start = 0, end = A.length - 1;
        while (start + 1 < end) { //at least 1 number apart -> avoid infinite loop
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid; // keep mid
            } else {
                end = mid; // keep mid
            }
        }

        if (A[end] < target)
            return end; // this is the closest --> as sorted anyway

        if (A[start] < target)  // so A[start] < target so set it first
            return start;

        return -1;
    }

}
