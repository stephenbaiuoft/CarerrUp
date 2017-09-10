package Amazon;

/**
 *
 Given a m x n matrix, if an element is 0,
 set its entire row and column to 0. Do it in place.

 click to show follow up.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 */


public class L73_SetMatrixZeroes_M {
    // no extra space:
    // idea to store in first row and first col ==>
    // use 2 variables to state first row and first col
    public void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        if(matrix!=null || matrix.length >0){
            for(int i= 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    if(matrix[i][j] == 0) {
                        if(i== 0) fr =true;
                        if(j==0) fc = true;

                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
/**
 for(int i = 1; i < matrix.length; i++) {
 for(int j = 1; j < matrix[0].length; j++) {
 if(matrix[i][0] == 0 || matrix[0][j] == 0) {
 matrix[i][j] = 0;
 }
 }
 }
 */
// ==> Note you only check i = 1 and j = 1 because that's the only recording area!!!!
            // do not make the mistake of starting from 0000000!!!s
            // check first col
            for(int i = 1; i < matrix.length; i++){
                if(matrix[i][0] == 0){
                    for(int j = 1; j < matrix[0].length; j ++){
                        matrix[i][j] = 0;
                    }
                }
            }
            // check first row
            for(int j = 1; j< matrix[0].length; j++){
                if(matrix[0][j] == 0){
                    for(int i = 1; i < matrix.length; i++){
                        matrix[i][j] = 0;
                    }
                }
            }

            if(fr) {
                //set entire first row
                for(int j = 0; j< matrix[0].length; j++){
                    matrix[0][j] = 0;
                }
            }
            if(fc){
                // set entire first col
                for(int i = 0; i < matrix.length; i++){
                    matrix[i][0] = 0;
                }
            }

        }
    }
}
