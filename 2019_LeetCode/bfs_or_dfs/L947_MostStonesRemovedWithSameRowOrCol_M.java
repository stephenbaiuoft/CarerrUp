package bfs_or_dfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

/*
* On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?



Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3

思路： 就是建立 graph 然后发现 # of edges   - 1 就是 最大的可以remove的stone的数量
重要的事情 ==》 怎么建立这个一个graph 根据given int[][] stones很重要！！！！

1. each edge is independent of another edge, (there is a way to do so)
2. so connected edges can be narrowed down to 1 point

* */
public class L947_MostStonesRemovedWithSameRowOrCol_M {
    public L947_MostStonesRemovedWithSameRowOrCol_M() {
        int[][] stones = new int[6][2];
        stones[0] = new int[]{0, 0};
        stones[1] = new int[]{0, 1};
        stones[2] = new int[]{1, 0};
        stones[3] = new int[]{1, 2};
        stones[4] = new int[]{2, 1};
        stones[5] = new int[]{2, 2};

        int n = removeStones(stones);
    }

    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) return 0;
        // let's build a graph of graph[n][n], where graph[i][0],
        // denotes the i node, and [i][0], the 0 is used to indicate tot number of nodes connected to node i
        // set n = stones.length --》 that's the maximum # of edges possible - 1 ( because 2 nodes makes 1 edge)
        int n = stones.length;
        // 把stones 标号为 [0， 1， 2， 3... N-1] 个node
        int[][] nodeGraph = new int[n][n];


        // iterate through the graph, where [i][0] element is used to denote total number of edges connected to ith node
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // connected condition --> same row or col --> ith's node row [i][0] == jth's node row [j][0]
                if (stones[i][0] == stones[j][0] ||
                        stones[i][1] == stones[j][1]) {
                    // 注意： ++ 先这样 先increment 就会成为1， 2， 3
                    nodeGraph[i][++nodeGraph[i][0]] = j; // nodeGraph[i][1] stores the 1st node that node_i connects to
                    // nodeGraph[i][2] stores the 2nd node node_i connects to
                    nodeGraph[j][++nodeGraph[j][0]] = i; // similarly for the node j with exact same notation
                }
            }
        }

        // visited to indicate whether a node has been visited or not
        boolean[] visited = new boolean[n];
        int totEdges = 0;
        // we need to traverse through the graph, and for each node, find # of edges linked to it
        // and, once a node is explored, then we skip that node only, we don't mark its neighbors as visited（这点很重要)
        // # of edges = # of nodes - 1

        // traverse through each nodeI, and find its neighbors and find tot # of edges
        for (int nodeI = 0; nodeI < n; nodeI++ ) {
            // bfs find all edges
            if (!visited[nodeI]) {


                totEdges--; // this is the offSet for making an edge
                // q meaning --> to be visited
                LinkedList<Integer> q = new LinkedList<>();
                q.add(nodeI);
                // mark as visited in advance
                visited[nodeI] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    totEdges++;

                    // explore neighbors
                    for (int i = 1; i <= nodeGraph[node][0]; i++) {
                        int neighbor = nodeGraph[node][i];
                        if (!visited[neighbor]) {
                            q.add(neighbor);
                            // mark those neighbor as visited because next iteration, you might use it again
                            visited[neighbor] = true;
                        }
                    }
                }
            }

        }

        // return the total number of edges
        return totEdges;
    }


}
