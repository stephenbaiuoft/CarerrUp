package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*

You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules,
return -1.

* */
public class L317_H {
    public L317_H() {
        int[][] grid = new int[][] {
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };

        int rez = shortestDistance(grid);


    }

    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
        int[][] metOnes = new int[grid.length][grid[0].length];
        int[][] metDist = new int[grid.length][grid[0].length];

        int minDist = Integer.MAX_VALUE;
        int totalOnes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalOnes++;
                    bfs(grid, metDist, metOnes, i, j);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (metOnes[i][j] == totalOnes && metDist[i][j] > 0) {
                    minDist = Math.min(minDist, metDist[i][j]);
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private static void bfs(int[][] grid, int[][] metDist, int[][] metOnes, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[i][j] = true;
        int dist = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int k = 0; k < sz; k++) {
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        metDist[nx][ny] += dist;
                        metOnes[nx][ny]++;
                        q.add(new int[]{nx, ny});

                    }
                }
            }
            dist++;
        }
    }
}
