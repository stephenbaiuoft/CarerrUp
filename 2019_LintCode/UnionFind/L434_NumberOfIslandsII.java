package UnionFind;

import java.util.ArrayList;
import java.util.List;

/*
* Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
  Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
  The list pair has k operator and each operator has two integer A[i].x, A[i].y means that
   you can change the grid matrix[A[i].x][A[i].y] from sea to island.

   Return how many island are there in the matrix after each operator.
*
* */
public class L434_NumberOfIslandsII {

     class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
     }


    class UnionSet {
        protected int[] parents = null;

        public UnionSet(int n, int m) { // # of rows and # of cols
            parents = new int[n*m]; // 1 - n

            for (int i = 0; i < n*m; i++) {
                parents[i] = i;
            }
        }

        private int findParents(int u) {
            int pu = parents[u];
            if (pu != u) {
                parents[u] = findParents(parents[u]);
            }

            return parents[u];
        }

        public void connect(int a, int b) {
            // write your code here
            int pa = findParents(a);
            int pb = findParents(b);
            if (pa != pb)
                parents[pa] = pb;
        }
    }

    private int flatternCoordinate( int row,  int col, int colSize) {
        return row * colSize + col; // which particular one
    }

    public L434_NumberOfIslandsII() {
         Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        Point p3 = new Point(1,0);
        Point p4 = new Point(0,1);
        Point[] operators = new Point[] {
                p1,p2,p3,p4
        };

        List<Integer> l = numIslands2(2,2, operators);
        System.out.println(l);
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> ans = new ArrayList<Integer>();
        if (operators == null) {
            return ans;
        }

        int []dx = {0,-1, 0, 1};
        int []dy = {1, 0, -1, 0};
        int [][]island = new int[n][m];

        UnionSet uf = new UnionSet(n, m);
        int count = 0;

        for (int i = 0; i < operators.length; i++) {
            int x = operators[i].x;
            int y = operators[i].y;
            if (island[x][y] != 1) {
                count ++;
                island[x][y]  = 1;
                int id = flatternCoordinate(x, y, m);
                for (int j = 0 ; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && island[nx][ny] == 1) {
                        int nid = flatternCoordinate(nx, ny, m);
                        int pid = uf.findParents(id);
                        int npid = uf.findParents(nid);
                        if (pid != npid) {
                            count--;
                            uf.connect(id, nid);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }


}
