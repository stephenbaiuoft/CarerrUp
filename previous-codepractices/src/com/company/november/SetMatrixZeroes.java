package com.company.november;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class SetMatrixZeroes {

    void setZeroes( int[][] matrix ) {
        //given mxn matrix

        if((matrix ==null) ||(matrix.length ==0) )  return;
        int m = matrix.length, n = matrix[0].length;

        // find if the 1st/Oth row/col needs to be set as zero
        // use them to store so it saves space
        Boolean isFirstRowZero = false;
        Boolean isFirstColZero = false;
        // tricky as we mean accessing entire first row
        // so j-n, getting cols for row 0
        for(int j=0; j<n; j++) {
            if(matrix[0][j]==0) {
                isFirstRowZero = true;
                break;
            }
        }

        // check first/0th col, so [i][0] for this
        // note if zero, then other values can be safely ignored
        for(int i=0; i<m; i++) {
            if(matrix[i][0]==0) {
                isFirstColZero = true;
                break;
            }
        }

        // use 1st row/col to record whether to set each col/row as zero
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j]==0) {
                    // save to matrix[i][0], 0th col
                    // save to matrix[0][i], 0th row
                    // 0 mean Yes, that cell's row&&col should be set
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // set rows & cols
        for(int i=1; i<m; i++) {
            // setting row
            if(matrix[i][0]==0) setRowCol(matrix, i, true);
        }
        for(int j=1; j<n; j++) {
            if(matrix[0][j]==0) setRowCol(matrix, j, false);
        }

        // set first row & col
        if(isFirstRowZero) setRowCol(matrix, 0, true);
        if(isFirstColZero) setRowCol(matrix, 0, false);
    }

    void setRowCol(int[][]matrix, int index, Boolean isSetRow) {
        if(matrix == null || matrix.length ==0)  return;

        // get row and colmn
        int m = matrix.length, n = matrix[0].length;
        // preCaution only
        if((isSetRow && index>=m) || (!isSetRow && index>=n))
        {
            System.out.println("How I used it, dont think this will get run");
            return;}

        if(isSetRow) {
            // n-> columnes
            for(int j=0; j<n; j++)
                matrix[index][j] = 0;
        }
        else {
            for(int i=0; i<m; i++)
                matrix[i][index] = 0;
        }
    }
}
