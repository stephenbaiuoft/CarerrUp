package ByMonth.august.March;

public class L37_SudokuSolver_H {
    // 9 and ignore 0th (use 1-9 in 2nd dimension only)
    private int[][] rowSet = new int[9][10];
    private int[][] colSet = new int[9][10];
    // keyIndex of matrixSet is   x/3 * 3 + y/3 ( x: # of rows, y: # of cols)
    private int[][] matrixSet = new int[9][10];

    public boolean solveSudoku(char[][] board) {

        // think of as 9 row 3x3 maze, (rowSet)
        // 9 col 3x3 maze (colSet)
        // 9 sets of 3x3 maze (matrixSet)

        // initialize rowSet, colSet, matrixSet (in terms of the 9 matrix)
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                // pre-set values
                if(board[i][j] != '.') {
                    // get the currentValue and set the index to be 1
                    int cVal = board[i][j] - '0';
                    // set matrixSet
                    int keyMatrix = (i/3) * 3 + (j / 3);
                    matrixSet[keyMatrix][cVal] = 1;
                    //  set the corresponding index of rowSet and colSet
                    rowSet[i][cVal] = 1;
                    colSet[j][cVal] = 1;
                }
            }
        }

        // now go and fillBoard with starting index of x and y (0,0) in this case
        return fillBoard(board, 0, 0);

    }

    // fill the board and x (# of rows), y (# of cols)
    private boolean fillBoard(char[][] board, int x, int y) {
        // finished the last point of (8,8)
        if (x==9) return true;

        int ny = (y + 1 ) % 9;
        // advance to next row, when the ny (col is 0)
        int nx = (ny == 0) ? x+1: x;

        // if x,y position is filled already, move to next position
        if (board[x][y] != '.') return fillBoard(board, nx, ny);

        // here is enumeration happens (i is the value)
        for(int i = 1; i <=9; i++) {
            int matrixKey = (x/3) * 3 + (y /3);
            // if this value is not chosen by any of the matrices
            if (matrixSet[matrixKey][i] != 1 && rowSet[x][i] != 1
                    && colSet[y][i] != 1) {
                // CHOOSE
                matrixSet[matrixKey][i] = 1;
                rowSet[x][i] = 1;
                colSet[y][i] = 1;
                // set the board[x][y]
                board[x][y] = (char) (i + '0');
                // EXPLORE
                if( fillBoard(board, nx, ny)) return true;

                // UNCHOSE
                matrixSet[matrixKey][i] = 0;
                rowSet[x][i] = 0;
                colSet[y][i] = 0;
                board[x][y] = '.';
            }

        }
        // default no possible values to fill --> so false
        return false;
    }
}
