package Amazon;

// Idea: mid way search
/*
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
                };

                int[][] matrix1 = {
                {-1,3}
                };
                Search2DMatrix_240_M program = new Search2DMatrix_240_M();
                System.out.println ( program.searchMatrix(matrix1, 3));
*/

public class Search2DMatrix_240_M {

    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length;
        // col is column index!
        int col = matrix[0].length - 1;

        for (int i = 0 ; i < row ; i ++ ){
            if (matrix[i][col] >= target && searchRow(matrix[i], 0, col, target)) {
                return true;
            }
        }

        return false;
    }

    // search for target using mid search
    private boolean searchRow(int[] row, int lowIndex, int highIndex, int target){
        if (highIndex - lowIndex <= 1){
            if (row[lowIndex] == target || row[highIndex] == target){
                return true;
            }
            // not exist in this row
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
