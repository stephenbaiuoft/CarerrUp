package graph.dijkstra;

import java.util.*;

public class L787_CFlightsWithKStops_M {

    public static void main(String[] args) {
        L787_CFlightsWithKStops_M l = new L787_CFlightsWithKStops_M();
    }

    public L787_CFlightsWithKStops_M() {
        int[][] flights = new int[3][3];
        flights[0] = new int[] {0, 1, 100};
        flights[1] = new int[] {1, 2, 200};
        flights[2] = new int[] {3, 2, 700};

        findCheapestPrice(4, flights, 0, 2, 3);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // Build the adjacency matrix
        int adjMatrix[][] = new int[n][n];
        for (int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        // Shortest distances array
        int[] distances = new int[n];

        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currentStops[src] = 0;

        // The priority queue would contain (node, cost, stops)
        // cost being cost to reach to Node so far with # of stops given
         // -> it's not optimal cost because we haven't finished exploring all paths to the node yet!!!!!
         // ---> it's only done with minQueue is empty!!! that is no more to explore!!!
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {

            int[] info = minHeap.poll();
            int node = info[0], stops = info[2], cost = info[1];

            // If destination is reached, return the cost to get here
            if (node == dst) {
                return cost;
            }

            // If there are no more steps left, continue
            if (stops == K + 1) {
                continue; // 如果已经超出了 那么之后的全部不会处理
            }

            // Examine and relax all neighboring edges if possible
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int dU = cost, dV = distances[nei], wUV = adjMatrix[node][nei];

                    // Better cost?
                    // 在这里， 一定是 stops + 1 <= K的 所以可以relax
                    if (dU + wUV < dV) {
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                    }
                    /**
                     * However, if we ever encounter a node that has already been processed before
                     * but the number of stops from the source is lesser than what was recorded before,
                     * we will add it to the heap so that it gets considered again!
                     *
                     * -> 因为stops不一样 所以即使reprocess也是okay的
                     *   --》 这是else if的情况
                     *   所以 这个情况 只能在 du + wUV >= dv的情况 stops < currentStops[nei]
                     *   也就说
                     *    在能relax的时候 一定去relax
                     *    在这个情况 只能是 发现了一个新路线 而且这个新路线比已有的要短！（Stops要少)
                     *    那为什么跟新？？？
                     *     - 因为这样 你可以 多一条路线的可能性 比如这个nei是 5
                     *      [5, 12, 2]
                     *      [5, 10, 3]
                     *      这2个都会在pq里面！！！！
                     *      所以这里 whileQ notEmpty会继续处理这2个可能性！！！！！！！
                     *
                     * ==> 因为有stop的limit
                     */
                    else if (stops < currentStops[nei]) {
                        // Better steps?
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                    }
                    currentStops[nei] = stops;
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE? -1 : distances[dst];
    }
}
