package BFS;

import java.util.*;

public class L794_SlidingPuzzleII {

    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        String ini = getString(init_state);
        String target = getString(final_state);

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.offer(ini);
        visited.add(ini);

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // explore each level
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step; // found
                }

                for (String next: getNext(cur)) {
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            step ++;
        }

        return -1; // not possible
    }

    private String getString(int[][] state) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(state[i][j]);
            }
        }
        return sb.toString();
    }

    private List<String> getNext(String state) {
        List<String> nextStates = new ArrayList<>();
        int[] dx = new int[]{0, 1, -1, 0};
        int[] dy = new int[]{1, 0, 0, -1};

        int zeroIdx = state.indexOf('0');
        int x = zeroIdx /3;
        int y = zeroIdx %3;

        int nX, nY = 0;
        for (int i = 0; i < 4; i++) {
            nX = x + dx[i];
            nY = y + dy[i];
            if (nX < 0 || nY < 0 || nX >=3 || nY >=3) {
                continue; // skip these entries
            }

            char[] chars = state.toCharArray();
            // swap
            chars[x * 3 +  y] = chars[ nX * 3 + nY];
            chars[nX * 3 + nY] = '0';
            // add to nextStates
            nextStates.add(String.valueOf(chars));
        }

        return nextStates;
    }
}

