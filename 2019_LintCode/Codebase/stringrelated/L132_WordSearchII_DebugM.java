package Codebase.stringrelated;

import java.util.*;

public class L132_WordSearchII_DebugM {
    public void runTest() {


    }

    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        if (board == null || board[0].length < 1) return new LinkedList<>();

        HashMap<String, Boolean> map = new HashMap<>();
        HashSet<String> rez = new HashSet<>();
        buildHash(words, map);

        for(int i = 0; i <board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, "", rez, map);
            }
        }

        return new ArrayList<>(rez);
    }

    // dfs through possibilities
    private void dfs(char[][] board, int x, int y, String cur, HashSet<String> rez, HashMap<String, Boolean> map) {
        // base cases
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        // skip visited entries
        if (!Character.isLetter(board[x][y])) return;

        // is a valid letter --> not visited
        cur += board[x][y];
        board[x][y] ^= '#'; // mark as visited -> so not character any more

        if (!map.containsKey(cur))
            return;

        // if is word in the map --> then we should add to list
        if (map.get(cur)) {
            rez.add(cur);
        }

        // 4 directions-> left, right, up, down
        int[] xMove = new int[]{-1, 1, 0, 0};
        int[] yMove = new int[]{0, 0, 1, -1};
        int nX = 0;
        int nY = 0;
        for(int dir = 0; dir < 4; dir++) {
            nX = x + xMove[dir];
            nY = y + yMove[dir];
            dfs(board, nX, nY, cur, rez, map);
        }

        // restore back
        board[x][y] ^= '#';

    }


    // map -> exists ( prefix exists)
    // map.get(word) == true --> isWord
    private void buildHash(List<String> words, HashMap<String, Boolean> map) {
        for(String w: words) {
            for (int i = 0; i < w.length()-1; i++) {
                if (!map.get(w.substring(0, i+1))) {
                    map.put(w.substring(0, i+1), false);
                }
            }
            // update the last entry
            map.put(w, true);
        }
    }

}
