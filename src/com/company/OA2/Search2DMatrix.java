package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class Search2DMatrix {
    public Search2DMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;

    }

    // search for target using mid search
    private boolean searchRow(int[] row, int lowIndex, int highIndex, int target){
        if (lowIndex == highIndex){
            if (row[lowIndex] == target){
                return true;
            }
            // not existing
            return false;
        } else {
            int mid = ( lowIndex + highIndex ) / 2;
            if (row[mid] > target){
                return searchRow(row, lowIndex, mid, target);
            } else {
                return searchRow(row, mid, highIndex, target);
            }
        }
    }


}
