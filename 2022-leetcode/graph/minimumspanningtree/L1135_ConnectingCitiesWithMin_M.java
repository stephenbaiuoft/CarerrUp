package graph.minimumspanningtree;

import java.util.*;


public class L1135_ConnectingCitiesWithMin_M {

    public static void main(String[] args) {
        L1135_ConnectingCitiesWithMin_M p = new L1135_ConnectingCitiesWithMin_M();
    }

    public L1135_ConnectingCitiesWithMin_M() {

        int[][] connections = new int[2][3];
        connections[0] = new int[] {1,2,3};
        connections[1] = new int[] {3,4,4};
        //[[1,2,3],[3,4,4]];
        minimumCost(4, connections);
    }


    // https://leetcode.com/problems/connecting-cities-with-minimum-cost/

    /**
     * PRIM'S ALGORITHM
     *
     * There are n cities labeled from 1 to n. You are given the integer n and an array connections where connections[i] = [xi, yi, costi]
     * indicates that the cost of connecting city xi and city yi
     * (bidirectional connection) is costi.
     *
     * Return the minimum cost to connect all the n cities such that there is at least one path between each pair of cities. If it is impossible to connect all the n cities, return -1,
     * ==> Visited.size() == N 来判定 因为你只会走N次
     * @param n
     * @param connections
     * @return
     */
    public int minimumCost(int n, int[][] connections) {
        // build graph
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        // minQueue stores weight to a node [weight, node]
        Queue<int[]> minQueue = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        HashSet<Integer> visited = new HashSet<>();
        int cost = 0;

        // city are from 1 to N);
        // city are from 1 to N
        for (int c = 1; c <= n; c++) {
            graph.put(c, new LinkedList<>());
        }

        // per connection -> graph with weights
        for (int[] c: connections) {
            //
            graph.get(c[0]).add(new int[] {c[1], c[2]});
            graph.get(c[1]).add(new int[] {c[0], c[2]});
        }

        // starting point, cost of 0 to reach node 1
        minQueue.offer(new int[]{0, 1});
        // i only literates n times
        for (int i = 0; i < n; i++) {
            // The following Logic
            // is getMin edge based on the nodes explored so far
            //  --> nodesExplored so far is in the minQueue
            while (true) {  // While true always the OUTER LOOP
                int[] info = minQueue.poll();
                // No longer can be expanding
                if (info == null) return -1;

                int weight = info[0];
                int curNode = info[1];

                // If node visited already, continue, skip this --> UNDIRECTED GRAPH
                if (visited.contains(curNode)) continue;

                // not visited, update cost
                cost += weight;
                visited.add(curNode); // update this as visited

                for (int[] neighbor: graph.get(curNode)) {
                    // not visited neighbor
                    if (!visited.contains(neighbor[0])) {
                        // weight to neighbor[1]
                        minQueue.offer(new int[] {neighbor[1], neighbor[0]});
                    }
                }
                break; // Done with neighbors --> Let's go to next ITERATION!

            }
        }

        if (visited.size() == n) return cost;
        return -1;

    }
}
