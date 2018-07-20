package July;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.*;

public class L675_CutOffTrees_H {
    private int[][] dir = {
            // left, right,     up,       down
            {0, -1}, {0, 1},    {-1, 0}, {1, 0}
    };

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.get(0).size() == 0) return 0;
        // init variables
        int sum = 0, m = forest.size(), n = forest.get(0).size() ;
        // given no two tress are of same height,
        // if a path exists, it will be followed strictly in ascending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]) );

        // scan through the forest to add and maintain this order
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // note do not include the 0 or 1 places
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }

        // need a function to compute the shortest path, if exists, from point a to point b
        // default starting point
        int[] start = new int[2];
        int[] nextTree = null;
        // traverse through the tree in order !!!
        while(!pq.isEmpty()) {
            nextTree = pq.poll();
            int val = sPath(start, nextTree, forest, m, n);
            // not found
            if (val == -1 ) return val;

            start[0] = nextTree[0];
            start[1] = nextTree[1];
            // increment sum
            sum += val;

        }

        return sum;

    }

    // computes the shortest path from start to end, if exists, -1 otherwise
    private int sPath(int[] start, int[] endTree, List<List<Integer>> forest, int m, int n) {
        int sum = 0;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(start);
        int[] cur = null;

        while(!q.isEmpty()) {
            int l = q.size();
            while(l > 0) {
                cur = q.poll();
                // base case: found and return sum directly
                if (cur[0] == endTree[0] && cur[1] == endTree[1]) return sum;
                // mark as visited
                visited[cur[0]][cur[1]] = true;
                // bfs trick
                int nr = 0, nc = 0;
                for(int[] d: dir) {
                    nr = cur[0] + d[0];
                    nc = cur[1] + d[1];
                    // skip this condition if visited already
                    if (nr < 0 || nc < 0 || nr >=m || nc >= n  ||
                            visited[nr][nc] || forest.get(nr).get(nc) < 1
                            ) continue;
                    // add the nearby to queue
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
                l--;
            }
            sum += 1;
        }

        // not found
        return -1;
    }
}
