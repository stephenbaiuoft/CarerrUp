package bfs_or_dfs.bfs;

import java.util.*;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/submissions/
public class L1091_ShortestPathBinaryMatrix_M {


    // Modify the grid as visited
    // Runtime: 18 ms, faster than 81.02%
    public int shortestPathBinaryMatrix(int[][] grid) {
        // base check
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        // Update distance info in the queue
        queue.add(new int[] {0, 0, 1});
        // Update grid as distance of 1
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            // Poll from the queue
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            // read from grid, distance to row, col
            int dist = grid[row][col];

            // if reached, given we do bfs, so minimum
            if (row == n-1 && col == m -1) {
                return dist;
            }

            List<int[]> neighbors = getNeighbors(row, col, grid);
            for (int[] neighbor: neighbors) {
                // Add unexplored to path
                queue.add(new int[]{ neighbor[0], neighbor[1] });
                // update visited --> This reduces # of neighbors added with the for-loop
                grid[neighbor[0]][neighbor[1]] = dist + 1;
            }

        }

        return -1;

    }

    // Use another to track the distance!!!
    // Runtime: 30 ms, faster than 43.37%
    public int shortestPathBinaryMatrixVisitedWithoutDistance(int[][] grid) {

        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        // Update distance info in the queue
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        int dist = 1;

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                // Poll from the queue
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];

                // if reached, given we do bfs, so minimum
                if (row == n-1 && col == m -1) {
                    return dist;
                }

                List<int[]> neighbors = getNeighbors(row, col, grid);
                for (int[] neighbor: neighbors) {
                    if (visited[neighbor[0]][neighbor[1]]) {continue;}

                    // Add unexplored to path
                    queue.add(new int[]{ neighbor[0], neighbor[1]});

                    // update visited --> This reduces # of neighbors added with the for-loop
                    visited[neighbor[0]][neighbor[1]] = true;
                }
            }
            // update dist by 1 as it's 1 level up
            dist ++;

        }
        return -1;
    }

    public int shortestPathBinaryMatrixVisited(int[][] grid) {

        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        // Update distance info in the queue
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            // Poll from the queue
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];

            // if reached, given we do bfs, so minimum
            if (row == n-1 && col == m -1) {
                return dist;
            }

            List<int[]> neighbors = getNeighbors(row, col, grid);
            for (int[] neighbor: neighbors) {
                if (visited[neighbor[0]][neighbor[1]]) {continue;}

                // Add unexplored to path
                queue.add(new int[]{ neighbor[0], neighbor[1], dist + 1});

                // update visited --> This reduces # of neighbors added with the for-loop
                visited[neighbor[0]][neighbor[1]] = true;
            }

        }

        return -1;

    }

    // Returns valid possibilities
    public List<int[]> getNeighbors(int row, int col, int[][] grid) {
        List<int[]> answer = new LinkedList<>();
        // generate all directions other than row, col
        for (int i = -1; i <= 1; i ++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                else {
                    int newRow = row + i;
                    int newCol = col + j;
                    if (newRow < 0 || newCol < 0 || newRow >= grid.length
                            || newCol >= grid[0].length
                            || grid[newRow][newCol] != 0) {
                        continue;
                    } else { // valid
                        answer.add(new int[]{newRow, newCol});
                    }
                }

            }
        }

        return answer;
    }
}
