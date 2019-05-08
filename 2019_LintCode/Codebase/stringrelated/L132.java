package Codebase.stringrelated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L132 {
    int[] xMove = new int[]{-1, 1, 0, 0};
    int[] yMove = new int[]{0, 0, 1, -1};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        if (board == null || board.length == 0) {
            return new ArrayList<>();
        }
        if (board[0] == null || board[0].length == 0) {
            return new ArrayList<>();
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        HashMap<String, Boolean> map = new HashMap<>();
        buildHash(words, map);
        HashSet<String> wordSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = true;
                dfs(board, visited, i, j, String.valueOf(board[i][j]), map, wordSet);
                visited[i][j] = false;
            }
        }

        return new ArrayList<String>(wordSet);
    }

    // map -> exists ( prefix exists)
    // map.get(word) == true --> isWord
    private void buildHash(List<String> words, HashMap<String, Boolean> map) {
        for(String w: words) {
            for (int i = 0; i < w.length()-1; i++) {
                if (map.get(w.substring(0, i+1))== null) {
                    map.put(w.substring(0, i+1), false);
                }
            }
            // update the last entry
            map.put(w, true);
        }
    }

    private void dfs(char[][] board,
                     boolean[][] visited,
                     int x,
                     int y,
                     String word,
                     HashMap<String, Boolean> prefixIsWord,
                     HashSet<String> wordSet) {
        if (!prefixIsWord.containsKey(word)) {
            return;
        }

        if (prefixIsWord.get(word)) {
            wordSet.add(word);
        }

        for (int i = 0; i < 4; i++) {
            int nX = x + xMove[i];
            int nY = y + yMove[i];

            if (outside(board, nX, nY) || visited[nX][nY]) {
                continue; // skip
            }

            visited[nX][nY] = true;
            dfs(board, visited, nX, nY, word + board[nX][nY], prefixIsWord, wordSet);
            visited[nX][nY] = false;
        }
    }

    private boolean outside(char[][] board, int x, int y) {
        if  (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return true;
        return false;
    }

}
