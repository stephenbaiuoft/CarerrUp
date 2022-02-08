import java.util.HashMap;

public class L348_M {
    public L348_M() {
        TicTacToe p = new TicTacToe(3);
        int v = 0 ;
        v = p.move(1, 1, 1);
        v = p.move(0, 0,  1);
        v = p.move(2, 2, 1);
        System.out.print(v);
    }

    class TicTacToe {
        private int l = 0;
        public HashMap<Integer, Integer> rowMap = null;
        public HashMap<Integer, Integer> colMap = null;
        // -1, 1 to indicate left digonal, and right digonal
        public HashMap<Integer, Integer> diagMap = null;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            // diagonal use -1 for left diagonal, -2 for right diagonal
            // digonal matrix values (row+col = n - 1)
            // 0-n-1 to indicate each row
            // 0-n-1 to indicate each col
            rowMap = new HashMap<>();
            colMap = new HashMap<>();
            // -1, 1 to indicate left digonal, and right digonal
            diagMap = new HashMap<>();
            l = n;

        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            if (player == 1 ) {
                if (update(rowMap, row, 1) == l) return player;
                if (update(colMap, col, 1) == l) return player;
                if (row+col == l - 1) {
                    if (update(diagMap, 1, 1) == l) return player;
                }
                if (row == col) {
                    if (update(diagMap, -1, 1) ==l) return player;
                }
            } else {
                if (update(rowMap, row, -1) == -l) return player;
                if (update(colMap, col, -1) == -l) return player;
                if (row+col == l - 1) {
                    if (update(diagMap, 1, -1) == -l) return player ;
                }
                if (row == col) {
                    if (update(diagMap, -1, -1) == -l) return player;
                }
            }

            return 0;
        }

        // update and return result
        private int update(HashMap<Integer, Integer> map, int key, int value) {
            if (!map.containsKey(key)) {
                map.put(key, value);
                return value;
            } else {
                int v = map.get(key) + value;
                map.put(key, v);
                return v;
            }
        }
    }
}
