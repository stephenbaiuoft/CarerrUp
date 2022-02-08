package ByMonth.august.May;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class L785_BiPartite_M {
    public L785_BiPartite_M() {
        int[][] graph = new int[4][2];
        int[] a = new int[]{1};
        int[] b = new int[]{0, 3};
        int[] c = new int[]{3};
        int[] d = new int[]{1, 2};
        graph[0] = a;
        graph[1] = b;
        graph[2] = c;
        graph[3] = d;

        boolean rez = isBipartite(graph);
    }

    public boolean isBipartite(int[][] graph) {

        // map to store set A and set B (marked with True and False)
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < graph.length; i++) {
            if(!map.containsKey(i) && !dfs(map, graph, i, true)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(HashMap<Integer, Boolean> map, int[][] graph, int node, boolean gr) {
        if(map.containsKey(node)) {
            return map.get(node).equals(gr);
        }
        // other case
        map.put(node, gr);
        for(int neighbor: graph[node]) {
            if(!dfs(map, graph, neighbor, !gr)) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartiteIterative(int[][] g) {
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1;
                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    for (int adjacent : g[node])
                        if (colors[adjacent] == colors[node])
                            return false;
                        else if (colors[adjacent] == 0) {
                            q.add(adjacent);
                            colors[adjacent] = -colors[node];
                        }
                }
            }
        return true;
    }
}
