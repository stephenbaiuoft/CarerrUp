package matrix_related;

/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.


* */

/*
* 重点： col的incrementing 然后根据increasing这个property 你可以eliminate row还有col correspondinglym
* */
public class L240_Search2DMatrix_M {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||matrix[0].length == 0) return false;

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] > target) {
                // given each col in incrementing, so cannot be this col
                // and we increment row 1 by 1 right
                col--;
            }
            else if (matrix[row][col] < target) {
                row++;
            }
        }

        return false;
    }
}
