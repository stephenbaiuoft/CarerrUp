package ByMonth.august.May;

import java.util.LinkedList;

public class L723_CandyCrush_M {
    /*
    * 最重要都就是 扫描棋盘 然后标注
    * 第二个是： 消灭都办法：  top && bot 很聪明  是一列一列来消 简单都做法
    * */
    public int[][] candyCrush(int[][] board) {
        // set to store the cancelled ones
        LinkedList<int[]> list = new LinkedList<>();
        int row = board.length;
        int col = board[0].length;
        int val = 0;

        // loop and set those indices where
        // they should be crushed
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                val = board[i][j];
                if (val != 0) {
                    // check continuous row
                    if (j + 2 < col && board[i][j+1] == val && board[i][j+2] == val) {
                        for(int k = j; k < col && board[i][k] == val; k++) {
                            list.add(new int[] {i, k});
                        }
                    }

                    // check continuous col
                    if (i + 2 < row && board[i+1][j] == val && board[i+2][j] == val) {
                        for(int l = i; l < row && board[l][j] == val; l++) {
                            list.add(new int[] {l, j});
                        }
                    }
                }
            }
        }
        // base case condition --> stable case (nothing needs to be crushed)
        if (list.size() == 0) return board;

        // set those indices to 0
        for(int[] index: list) {
            board[index[0]][index[1]] = 0;
        }

        // algo to crush the candy
        for(int j = 0; j < col; j++) {
            // 2 pointers to loop and change the board vertically
            int bot = row - 1;
            int top = row - 1;
            while(top > -1) {
                if(board[top][j] == 0) {
                    // move top
                    top--;
                }
                else {
                    board[bot--][j] = board[top--][j];
                }
            }

            while(bot > -1) {
                board[bot--][j] = 0;
            }
        }

        return candyCrush(board);

    }
}
