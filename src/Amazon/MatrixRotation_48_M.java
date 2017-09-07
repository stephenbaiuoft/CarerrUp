package Amazon;

/*
*        MatrixRotation_48_M program = new MatrixRotation_48_M();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        program.rotate(matrix);
*
* */
// Idea: transpose and fold the matrix is what causes the rotation
public class MatrixRotation_48_M {

    public void rotate(int[][] matrix) {

        transpose(matrix);
        fold(matrix);
    }

    // returns a tranposed matrix
    private void transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < i; j++) {

                    matrix[j][i] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[j][i];
                    matrix[j][i] ^= matrix[i][j];
            }
        }
        System.out.println("transposed one:");
        printMatrix(matrix);
    }

    // clockwise rotation: fold horizontally:
    private void fold(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i ++) {
            for (int j = 0; j < col/2; j ++) {
                matrix[i][j] ^= matrix[i][col - 1 - j];
                matrix[i][col - 1 - j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][col -1 - j];
            }
        }

        System.out.println("folded one:");
        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + ",") ;
            }
            System.out.println();
        }
    }
}
