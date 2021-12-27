package ByMonth.august.March;

public class L48_RotateMatrix_M {
    public void rotate(int[][] matrix) {
        // transpose and flip vertically
        if(matrix == null || matrix.length ==0) return;

        // do the in-place operation
        transpose(matrix);
        flip(matrix);
    }

    private void transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i =0; i < row; i++) {
            for(int j = i + 1; j < col; j++) {
                // xor logic
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
    }

    private void flip(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col/2; j++) {
                matrix[i][j] ^= matrix[i][col-1-j];
                matrix[i][col-1-j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][col-1-j];
            }
        }

    }
}
