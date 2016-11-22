package com.company.OA2;

/**
 * Created by stephenbai on 2016-11-18.
 */
public class Search2DMatrix {
    public Search2DMatrix(){

    }

    public boolean searchMatrix(int[][]matrix, int k ){
        if ((matrix==null)||(matrix.length==0)) return false;
        int numRow = matrix.length;
        int numCol = matrix[0].length;

        // search row using log
        int sRow = 0;
        int fRow = numRow - 1;
        int row;
        // [sRow][0] [fRow][numCol - 1]
        while(fRow - sRow > 1){
            int mid = sRow + (fRow - sRow)/2;
            if( matrix[mid][0] > k){
                // advance end
                fRow = mid;
            }else if(matrix[mid][0] < k){
                sRow = mid;
            }else{
                // as [mid][0] is found
                return true;
            }
        }
        // check either sRow or fRow
        if ( k < matrix[sRow][numCol-1] ){
            row = sRow;
        }else if (k > matrix[sRow][numCol-1]){
            row = fRow;
        }else{
            return true;
        }

        // search column
        int sCol = 0;
        int fCol = numCol - 1;
        int col;
        while(fCol - sCol > 1){
            int mid = sCol + (fCol - sCol)/2;
            if (matrix[row][mid] > k){
                // safe to move sCol
                fCol = mid;
            }else if(matrix[row][mid] < k)
            {	// safe to move fCol
                sCol = mid;
            }else{
                return true;
            }
        }

        if (matrix[row][sCol] == k ){
            return true;
        }else if (matrix[row][fCol] == k){
            return true;
        }else{
            return false;
        }
    }
}
