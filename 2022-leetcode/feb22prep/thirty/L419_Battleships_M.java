package feb22prep.thirty;

public class L419_Battleships_M {
    /**
     * Battle ship 1 pass
     *
     * 注意就是 顶点的X 以及最右边的X 查询这个条件
     *
     *
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }

        return count;

    }

    // dfs solution
    // visited for the board, -> we can modify the board , v -> visisted, . empty as is, and x is a battleship
    // if not visited, for a x, then it is
    // otherwise, +1 and dfs from it
    private void dfs(char[][] visited, int i, int j) {
        if (i < 0 || j < 0 ||
                i >= visited.length || j >= visited[0].length ) return;

        if (visited[i][j] == 'V' || visited[i][j] == '.') { // visited or hit empty
            return;
        }

        if (visited[i][j] == 'X') {
            // Mark as visited
            visited[i][j] = 'V';

            dfs(visited, i, j + 1);
            dfs(visited, i+1, j);
        }

    }
}
