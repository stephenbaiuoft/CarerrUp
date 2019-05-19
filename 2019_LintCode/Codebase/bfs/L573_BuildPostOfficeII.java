package Codebase.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L573_BuildPostOfficeII {
    class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int n = 0;
    private int m = 0;
    private int[][] grid = null;
    private int[] dx = new int[] {0, 1, -1, 0};
    private int[] dy = new int[] {-1, 0, 0, 1};


    // empty 0, house = 1, wall = 2
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        int[][] distSum = new int[n][m];
        int[][] visitedCount = new int[n][m];
        List<Coordinate> houses = buildCordinates(1);
        List<Coordinate> empties = buildCordinates(0);
        int minD = Integer.MAX_VALUE;

        for (Coordinate house: houses) {
            bfs(house, distSum, visitedCount);
        }

        for (Coordinate empty: empties) {
            // this spot has to be reachable by all houses... obviously --> excluding walls
            if (visitedCount[empty.x][empty.y] != houses.size()) {
                continue;
            }

            minD = Math.min(minD, distSum[empty.x][empty.y]);
        }

        return minD == Integer.MAX_VALUE? -1: minD;
    }

    private List<Coordinate> buildCordinates(int type) {
        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == type) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }

        return coordinates;
    }

    private boolean canVisit(Coordinate coor) {
        if (coor.x < 0 || coor.x >= n) {
            return false;
        }
        if (coor.y < 0 || coor.y >= m) {
            return false;
        }
        // whether u can visit
        return grid[coor.x][coor.y] == 0;
    }

    //
    private void bfs(Coordinate start, int[][] distSum, int[][] visitedCount) {
      Queue<Coordinate> q=  new LinkedList<>();
      boolean[][] visited = new boolean[n][m];

      q.offer(start);
      visited[start.x][start.y] = true;
      int step = 0;
      while (!q.isEmpty()) {
          step++;
          int size = q.size();
          for (int i = 0; i < size; i++) {
              Coordinate cur = q.poll();
              for (int j = 0; j < 4; j++) {
                Coordinate next = new Coordinate(cur.x + dx[j],
                                                    cur.y + dy[j]);
                if (!canVisit(next) || visited[next.x][next.y]) {
                    continue; // skip
                }

                q.offer(next);
                visited[next.x][next.y] = true;

                distSum[next.x][next.y] += step;
                visitedCount[next.x][next.y]++;
              }
          }
      }

    }
}
