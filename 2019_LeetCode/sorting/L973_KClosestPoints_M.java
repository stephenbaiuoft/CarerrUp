package sorting;

/*
* We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

* */

import java.util.Arrays;

// 解体思路： qsort的那个解法
public class L973_KClosestPoints_M {
    public L973_KClosestPoints_M() {
        int[][] points = new int[][] {
          {1,3},{2,-2},{-2, 2}
        };

        int[][] rez = kClosest(points, 2);
    }

    public int[][] kClosest(int[][] points, int K) {
        // sort it first
        qSort(points, 0, points.length-1);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void qSort(int[][] points, int left, int right) {
        // if left and right is at least by 1 element
        if (left < right) {
            int mid = partition(points, left, right);
            qSort(points, left, mid-1);
            // this mid +1 ---> so we need left < right condition!!!!
            qSort(points, mid +1, right);
        }
    }

    // partition the given points to [left, mid], [mid+1, right] where
    // left points are <= points[mid] and mid+1 points are > points[mid]
    private int partition(int[][] points, int left, int right) {
        // let's say we always pick the right most point as our pivot point
        int pValue = computeD(points[right]);
        // rightMostSmall as the index that tracks the rightMost index smaller than pValue
        int rightMostSmall = left - 1;
        // j as the index that starts between [left, right-1]
        for (int j = left; j < right; j++) {
            if (computeD(points[j]) <= pValue ) {
                rightMostSmall++; // so rightMostSmall points to the index that is outside smaller value

                // unequal --> to avoid unnecessary swap
                if (rightMostSmall != j) {
                    swap(points, rightMostSmall, j);
                }
            }

        }

        // update rightMostSmall to swap with the pivot point
        rightMostSmall += 1;
        swap(points, rightMostSmall, right);

        // return the pivot point
        return rightMostSmall;
    }

    // swap the content between p1 and p2
    private void swap(int[][] points, int p1, int p2) {
        if (p1 != p2) {
            int tmpX = 0, tmpY = 0;
            tmpX = points[p1][0];
            tmpY = points[p1][1];
            points[p1][0] = points[p2][0];
            points[p1][1] = points[p2][1];
            points[p2][0] = tmpX;
            points[p2][1] = tmpY;
        }
    }

    // given range --> no overflow for range int --> 10^4 -> 10^8 in the order
    // int is ~2.1*10^9
    private int computeD(int[] points) {
        // return x*x + y*y
        return points[0]*points[0] + points[1]*points[1];
    }

}
