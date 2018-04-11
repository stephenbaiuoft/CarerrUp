package March;

public class L419_BattleShip_M {
    public int countBattleships(char[][] board) {
        // Given we will not be given any INVALID EXAMPLES
        // idea: always look for top, left 'X' and count as 1
        //       --> other battleship blocks WILL NOT be like that
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                // top left --> top condition && left condition
                if (board[i][j] == 'X') {
                    // top left case along with edge cases (around the edge of the board)
                    if (((i > 0 && board[i-1][j] != 'X')|| (i == 0) )
                            &&((j==0) ||(j > 0 && board[i][j-1] != 'X') ) ){
                        count ++;
                    }

                }
            }
        }

        return count;
    }
}
