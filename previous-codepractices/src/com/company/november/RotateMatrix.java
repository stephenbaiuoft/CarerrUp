package com.company.november;

import java.util.Arrays;

/**
 * Created by stephenbai on 2016-11-10.
 */
public class RotateMatrix {

    public int[][] Solution(int[][] matrix, int flag) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)  return matrix;
        //int m = matrix.length, n = matrix[0].length;
        int[][] rvalue;
        rvalue = transpose(matrix);

        System.out.println(Arrays.deepToString(rvalue));
        flip(rvalue, flag);
        System.out.println(Arrays.deepToString(rvalue));

        return rvalue;
    }

    private int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] rvalue = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                rvalue[i][j] = matrix[j][i];
        return rvalue;
    }

    // 1 means 90 degree Right Rotation
    private void flip(int[][] matrix, int flag) {
        int m = matrix.length, n = matrix[0].length;
        if (flag == 1) {    //clock wise
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n / 2; j++) {
                    // XOR without temp is
                    // x, y ,x and always x^y, x^y, x^y
                    // x XOR 0 = x; and it's simply beautiful!
                    matrix[i][j] ^= matrix[i][n-j-1];
                    matrix[i][n-j-1] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[i][n-j-1];
                }
        }
        else {
            // left inverse and meaning left 90 degree rotation!
            for (int i = 0; i < m / 2; i++)
                for (int j = 0; j < n; j++) {
                    matrix[i][j] ^= matrix[m-i-1][j];
                    matrix[m-i-1][j] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[m-i-1][j];
                }
        }
    }

}
