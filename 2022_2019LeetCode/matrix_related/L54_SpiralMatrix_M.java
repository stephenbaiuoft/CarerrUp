package matrix_related;

import java.util.LinkedList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
* */



public class L54_SpiralMatrix_M {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> list = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return list;

        int rowStart = 0;
        int rowEnd = matrix.length -1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        // condition for the for-loop (both cases start <= end)
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // go right
            for(int i = colStart; i <= colEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            // increment rowStart by 1
            rowStart++;

            // go down by row
            for(int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            // decrement colEnd by 1
            colEnd --;

            // need to go left ==> check colEnd is greater than colStart
            if (rowStart <= rowEnd ) {
                for(int i = colEnd; i >= colStart; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd --;

            // need to  go up
            if (colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
            }

            colStart ++;

        }

        return list;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        // base condition
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            // go right
            for(int i = colStart; i <= colEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart += 1;

            // go down
            for(int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd -= 1;

            // go left
            // need to go left ==> check colEnd is greater than colStart
            if (rowStart <= rowEnd ) {
                for(int i = colEnd; i >= colStart; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd -=1;

            // go up
            // need to  go up
            if (colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
            }
            colStart += 1;
        }

        return list;
    }
}
